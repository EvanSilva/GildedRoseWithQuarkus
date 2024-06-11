package edu.badpals.domain;

public class Sulfuras extends Item implements Updateable{

    private Item item;

    public Sulfuras(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality = 80, "SULFURAS");
    }

    public Sulfuras(Item item) {
        this.item = item;
    }

    @Override
    public int getQuality() {
        return this.quality;
    }

    @Override
    public int getSellIn() {
        return this.sellIn;
    }

    @Override
    public void update_item() {
        // https://www.youtube.com/watch?v=mLyOj_QD4a4
    }

    @Override
    public void update_quality() {
        // LEEEEEEEEEEEEEEEEEEEEEEEEEEROY JEEEEEEEEEEEEEEEEEENKINS
        this.quality = 80;
    }
}