package com.weapp.service.products.repository;

import com.weapp.service.products.Application;
import com.weapp.service.products.entity.Barcode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
public class BarcodeRepositoryTest {

    private final String products_ID = "002560001";
    @Autowired
    private BarcodeRepository barcodeRepository;

    @Test
    public void findByBarcodeId_shouldExecute() {
        final Optional<Barcode> optionalBarcode = barcodeRepository.findById("0000099200992");
        assertThat(optionalBarcode).isNotNull();
        optionalBarcode
                .map(Barcode::getProducts)
                .ifPresent(products -> assertThat(products_ID).isEqualTo(products.getId()));

    }
}
