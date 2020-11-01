package com.weapp.service.items.repository;

import com.weapp.service.items.Application;
import com.weapp.service.items.entity.Items;
import com.weapp.service.items.service.ItemsService;
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
class ItemsRepositoryTest {

    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private ItemsService itemsService;

    @Test
    void findByDescriptionSqlLike_shouldExecute() {
        List<Items> items = itemsRepository.selByDescriptionLike("ACQUA ULIVETO");
        assertThat(items).size().isEqualTo(2);
    }

    @Test
    void findByDescriptionLike_shouldExecute() {
        final List<Items> items = itemsRepository.findByDescriptionLike("ACQUA%", PageRequest.of(0, 10));
        assertThat(items).size().isEqualTo(10);
    }

    @Test
    void findById_shouldExecute() {
        Items item = itemsService.findItemsById("7999182");
        assertThat(item).isNotNull();
        assertThat(item.getDescription()).isEqualTo("GHIACCIO 2LT IS MORI");

        Items item2 = itemsService.findItemsById("79991823");
        assertThat(item2).isNotNull();
        assertThat(item2.getDescription()).isNull();
    }
}