package com.weapp.service.items.repository;

import com.weapp.service.items.entity.Items;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemsRepository extends PagingAndSortingRepository<Items, String> {

    @Query("Select i FROM Items i WHERE i.description LIKE %:description%")
    List<Items> selByDescriptionLike(@Param("description") String description);

    List<Items> findByDescriptionLike(String description, Pageable pageable);

    Optional<Items> findById(String id);

}
