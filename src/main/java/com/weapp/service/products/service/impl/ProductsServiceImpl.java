package com.weapp.service.products.service.impl;

import com.weapp.service.products.entity.Products;
import com.weapp.service.products.repository.ProductsRepository;
import com.weapp.service.products.service.ProductsService;
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
@Transactional(readOnly = true)
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;


    @Override
    public Products findProductsById(String id) {
        Products products = new Products();
        if (Objects.nonNull(id) && isParsableAndGreaterThanZero(id)) {
            final Optional<Products> item = productsRepository.findById(id);
            return item.orElseGet(Products::new);
        }
        return products;
    }

    @Override
    public Iterable<Products> findAll() {
        return IterableUtils.emptyIfNull(productsRepository.findAll());
    }

    @Override
    public List<Products> findByDescription(String description) {
        if (StringUtils.isNotBlank(description)) {
            return ListUtils.emptyIfNull(productsRepository.selByDescriptionLike(description));
        }
        return new ArrayList<>();
    }

    @Override
    public List<Products> findByDescription(String description, Pageable pageable) {
        if (StringUtils.isNotBlank(description) && Objects.nonNull(pageable)) {
            return ListUtils.emptyIfNull(productsRepository.findByDescriptionLike(description, pageable));
        }
        return new ArrayList<>();
    }

    @Override
    @Transactional
    public void deleteProducts(Products products) {
        if (Objects.nonNull(products)) {
            productsRepository.delete(products);
        }
    }

    @Override
    @Transactional
    public void saveProducts(Products products) {
        if (Objects.nonNull(products)) {
            productsRepository.save(products);
        }
    }

    private boolean isParsableAndGreaterThanZero(String id) {
        return NumberUtils.isParsable(id) && new BigInteger(id).compareTo(BigInteger.ZERO) > 0;
    }
}
