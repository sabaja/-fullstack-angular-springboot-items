package com.weapp.service.products.repository;

import com.weapp.service.products.entity.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Products, String> {

    @Query("Select i FROM Products i WHERE i.description LIKE %:description%")
    List<Products> selByDescriptionLike(@Param("description") String description);

    List<Products> findByDescriptionLike(String description, Pageable pageable);

    Optional<Products> findById(String id);

}
