package edu.badpals.item;

public class Sulfuras extends Item implements Updateable{

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality = 80);
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