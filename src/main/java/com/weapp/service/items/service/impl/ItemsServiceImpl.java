package com.weapp.service.items.service.impl;

import com.weapp.service.items.entity.Items;
import com.weapp.service.items.repository.ItemsRepository;
import com.weapp.service.items.service.ItemsService;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;


    @Override
    public Items findItemsById(String id) {
        Items items = new Items();
        if (Objects.nonNull(id) && isParsableAndGreaterThanZero(id)) {
            final Optional<Items> item = itemsRepository.findById(id);
            return item.orElseGet(Items::new);
        }
        return items;
    }

    @Override
    public Iterable<Items> findAll() {
        return IterableUtils.emptyIfNull(itemsRepository.findAll());
    }

    @Override
    public List<Items> findByDescription(String description) {
        if (StringUtils.isNotBlank(description)) {
            return ListUtils.emptyIfNull(itemsRepository.selByDescriptionLike(description));
        }
        return new ArrayList<>();
    }

    @Override
    public List<Items> findByDescription(String description, Pageable pageable) {
        if (StringUtils.isNotBlank(description) && Objects.nonNull(pageable)) {
            return ListUtils.emptyIfNull(itemsRepository.findByDescriptionLike(description, pageable));
        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public void deleteItems(Items items) {
        if (Objects.nonNull(items)) {
            itemsRepository.delete(items);
        }
    }

    @Override
    @Transactional
    public void saveItems(Items items) {
        if (Objects.nonNull(items)) {
            itemsRepository.save(items);
        }
    }

    private boolean isParsableAndGreaterThanZero(String id) {
        return NumberUtils.isParsable(id) && new BigInteger(id).compareTo(BigInteger.ZERO) > 0;
    }
}
