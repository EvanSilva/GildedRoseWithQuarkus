package edu.badpals.item;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class Service {

    Service(){

    }

    @PersistenceContext
    jakarta.persistence.EntityManager em;

    @Transactional
    public void updateDatabase(){
        GildedRose store = new GildedRose();
        List<Item> items = Item.getEveryItem();
        for (Item item: items){
            store.addItem(ItemFactory.makeItem(item));
        }
        store.updateItems();
    }

    @Transactional
    void createItem(String name, int sell_in, int quality, String tipo){
        Item newItem = new Item(name, sell_in, quality, tipo);
        newItem.persist();
    }

    public void delete(Item item) {
        item.delete();
    }

}
