package edu.badpals.repository;

import edu.badpals.domain.Item;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class Repository {

    public List<Item> list(){

        List<Item> allItems = Item.listAll();
        return allItems;

    }

    @Transactional
    public void add(Item item) {

        Item itemToBeCreated = new Item(item.getName(), item.getSellIn(), item.getQuality(), item.getTipo());
        itemToBeCreated.persist();

    }

    @Transactional
    public void remove(String nombre, int sellin, int quality, String tipo) {

        Optional<Item> itemToKill = Item.find("name = ?1 and quality = ?2 and sellIn = ?3 and tipo = ?4", nombre, quality, sellin, tipo).firstResultOptional();

        if (itemToKill.isPresent()){

            itemToKill.get().delete();
        }

    }

    @Transactional
    public void removeAllByTipo(String tipo) {

        Item.delete("tipo = ?1", tipo);

    }

    public Optional<Item> getItem(String nombre) {

        Optional<Item> item = Item.find("name = ?1", nombre).firstResultOptional();

        if (item.isPresent()){
            return item;
        }

        return Optional.empty();
    }

}

