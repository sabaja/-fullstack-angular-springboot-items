package com.weapp.service.products.repository;

import com.weapp.service.products.entity.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarcodeRepository extends JpaRepository<Barcode, String> {

    Optional<Barcode> findById(String id);
}
