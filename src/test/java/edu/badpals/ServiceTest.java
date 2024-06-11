package edu.badpals;

import edu.badpals.domain.Item;
import edu.badpals.repository.Repository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@QuarkusTest
@Transactional
public class ServiceTest {

    @Inject
    Repository service;

    @Test
    public void test_mapping_Item() {
        Item item = Item.findById(1000);
        Assertions.assertThat(item).isNotNull();
        Assertions.assertThat(item.toString()).containsIgnoringCase("Elixir of the Mongoose"); // item_name
        Assertions.assertThat(item.toString()).contains("NORMAL"); // item_quality
        Assertions.assertThat(item.getId()).isEqualTo(1000);
    }

    @Test
    public void testList() {
        Assertions.assertThat(service.list()).hasSize(10);
    }

    @Test
    public void containsTest() {
        Assertions.assertThat(service.list().stream().anyMatch(f -> f.getName().equals("Aged Brie"))).isTrue();
    }

    @Test
    public void addTest() {
        service.add(new Item("Banana",
                1,
                10,
                "NORMAL"
                ));
        Assertions.assertThat(service.list()).hasSize(11);
        Assertions.assertThat(service.list().stream().anyMatch(f -> f.getName().equals("Banana"))).isTrue();

        // handmade rollback gracias al antipatron ActiveRecord ;)
        Item fruit = Item.findById(0);
        fruit.delete();
        Assertions.assertThat(Item.count()).isEqualTo(10);
    }

    @Test
    public void removeTest(){
        service.remove("Aged Brie", 0, 2, "AGED BRIE");
        Assertions.assertThat(service.list()).hasSize(9);
        Assertions.assertThat(Item.count()).isEqualTo(9L);

        // handmade rollback gracias al antipatron ActiveRecord ;)
        Item fruit = new Item("Aged Brie", 0, 2, "AGED BRIE");
        fruit.persist();
        Assertions.assertThat(Item.count()).isEqualTo(10);
    }

    @Test
    public void removeAllTest(){
        service.removeAllByTipo("AGED BRIE");
        Assertions.assertThat(service.list()).hasSize(8);
        Assertions.assertThat(Item.count()).isEqualTo(8L);

        // handmade rollback gracias al antipatron ActiveRecord ;)
        Item fruit = new Item(1001,"Aged Brie", 0, 2, "AGED BRIE");
        fruit.persist();
        Item fruit2 = new Item(1006,"Aged Brie", 1, 1, "AGED BRIE");
        fruit2.persist();
        Assertions.assertThat(Item.count()).isEqualTo(10);
    }

    @Test
    public void getItemTest() {
        Assertions.assertThat(service.getItem("Sulfuras, Hand of Ragnaros")).get().hasFieldOrPropertyWithValue("name", "Sulfuras, Hand of Ragnaros").hasFieldOrPropertyWithValue("sellIn", 80);
        Assertions.assertThat(service.getItem("Mandarina")).isEmpty();
    }

}
