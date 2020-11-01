package com.weapp.service.items.service;

import com.weapp.service.items.entity.Items;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemsService {

    Items findItemsById(String id);

     Iterable<Items> findAll();

     List<Items> findByDescription(String description);

     List<Items> findByDescription(String description, Pageable pageable);

     void deleteItems(Items items);

     void saveItems(Items items);
}
