package edu.badpals.domain;

public class NormalItem extends Item implements Updateable{

    private Item item;


    public NormalItem(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality, "NORMAL");
    }

    public NormalItem(Item item) {
        this.item = item;
    }

    @Override
    public int getQuality(){
        return this.quality;
    }

    @Override
    public int getSellIn(){
        return this.sellIn;
    }

    @Override
    public void update_item() {
        this.sellIn -= 1;
    }

    @Override
    public void update_quality() {

        if (this.sellIn <= 0 && this.quality >=2){
            this.quality -= 2 ;
        } else if (this.quality >=1){
            this.quality -= 1 ;
        }

    }
}