package edu.badpals.item;

import java.util.ArrayList;

public class GildedRose {

    public GildedRose() {
    }

    private final ArrayList<Updateable> inventory = new ArrayList<>();

    public ArrayList<Updateable> getInventory() {
        return inventory;
    }

    public void addItem(Updateable item) {
        inventory.add(item);
    }

    public void updateItems(){

        for (Updateable item: inventory){
            item.update_item();
            item.update_quality();
        }
    }

    @Override
    public String toString(){

        String stringConcatenation = "";

        for (Updateable item: inventory){

            stringConcatenation += item.toString() + "\n";
        }
        return stringConcatenation;
    }


}
