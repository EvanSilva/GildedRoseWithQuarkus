package edu.badpals;

import edu.badpals.domain.Item;
import edu.badpals.repository.Repository;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
@Transactional
public class ServiceTest {

    @Inject
    Repository service;

    @Test
    public void test_mapping_Fruit() {
        Item item = Item.findById(1);
        Assertions.assertThat(item).isNotNull();
        Assertions.assertThat(item.toString()).containsIgnoringCase("Elixir of the Mongoose"); // item_name
        Assertions.assertThat(item.toString()).contains("NORMAL"); // item_quality
        Assertions.assertThat(item.getId()).isEqualTo(1);
    }

}
