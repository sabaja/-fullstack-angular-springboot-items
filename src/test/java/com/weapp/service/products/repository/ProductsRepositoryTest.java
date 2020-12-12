package com.weapp.service.products.repository;

import com.weapp.service.products.Application;
import com.weapp.service.products.entity.Products;
import com.weapp.service.products.service.ProductsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
class ProductsRepositoryTest {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ProductsService productsService;

    @Test
    void findByDescriptionSqlLike_shouldExecute() {
        List<Products> products = productsRepository.selByDescriptionLike("ACQUA ULIVETO");
        assertThat(products).size().isEqualTo(2);
    }

    @Test
    void findByDescriptionLike_shouldExecute() {
        final List<Products> products = productsRepository.findByDescriptionLike("ACQUA%", PageRequest.of(0, 10));
        assertThat(products).size().isEqualTo(10);
    }

    @Test
    void findById_shouldExecute() {
        Products product = productsService.findProductsById("7999182");
        assertThat(product).isNotNull();
        assertThat(product.getDescription()).isEqualTo("GHIACCIO 2LT IS MORI");

        Products product2 = productsService.findProductsById("79991823");
        assertThat(product2).isNull();
    }

}