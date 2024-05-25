package edu.badpals.item;

public class BackstagePass extends Item implements Updateable{

    public BackstagePass(String name, int sellIn, int quality) {
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

        if (this.sellIn >10){
            this.quality += 1;

        } else if (this.sellIn >5) {
            this.quality += 2;

        } else if (this.sellIn >0) {
            this.quality += 3;
        } else {
            this.quality=0;
        }

        if (this.quality > 50) {
            this.quality = 50;
        }

    }

}