package edu.badpals.item;

public class ConjuredItem extends Item implements Updateable{

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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

        if (this.sellIn <= 0){
            this.quality -= 4 ;
        } else {
            this.quality -= 2 ;
        }
        if (this.quality < 0) {
            this.quality = 0;
        }

    }
}