package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //g
        Item item = new Item("itemA",10000,10);

        //w
        Item saveItem = itemRepository.save(item);
        //t
        Item findItem= itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }
    @Test
    void findAll() {
        //g
        Item item1 = new Item("itemA",10000,10);
        Item item2 = new Item("itemA",10000,10);
        //w
        itemRepository.save(item1);
        itemRepository.save(item2);
        //t
        List<Item> allItem = itemRepository.findAll();
        assertThat(allItem.size()).isEqualTo(2);
        assertThat(allItem).contains(item1,item2);

    }
    @Test
    void updateItem() {
        //g
        Item item1 = new Item("itemA",10000,10);
        Item savedItem = itemRepository.save(item1);
        Long itemId = savedItem.getId();
        //w
        Item updateParam = new Item("item2", 20000, 30);
        itemRepository.update(itemId,updateParam);

        //t
        Item id = itemRepository.findById(itemId);
        assertThat(id.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(id.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(id.getQuantity()).isEqualTo(updateParam.getQuantity());
    }

}










