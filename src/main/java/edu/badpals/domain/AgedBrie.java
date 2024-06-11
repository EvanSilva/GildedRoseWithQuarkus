package edu.badpals.domain;

public class AgedBrie extends Item implements Updateable  {

    private Item item;

    public AgedBrie(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality,"AGED BRIE");
    }

    public AgedBrie(Item item) {
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
        this.sellIn -= 1;
    }

    @Override
    public void update_quality() {

        if (this.sellIn <= 0 && this.quality <= 48){
            this.quality += 2 ;
        } else if(this.quality <= 49) {
            this.quality += 1 ;
        }

    }
}