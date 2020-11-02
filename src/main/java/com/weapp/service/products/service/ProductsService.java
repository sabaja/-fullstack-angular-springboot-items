package com.weapp.service.products.service;

import com.weapp.service.products.entity.Products;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductsService {

    Products findProductsById(String id);

     Iterable<Products> findAll();

     List<Products> findByDescription(String description);

     List<Products> findByDescription(String description, Pageable pageable);

     void deleteProducts(Products products);

     void saveProducts(Products products);
}
