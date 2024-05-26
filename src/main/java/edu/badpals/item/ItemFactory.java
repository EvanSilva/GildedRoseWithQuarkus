package edu.badpals.item;

public class ItemFactory {

    public static Updateable makeItem(Item item) {
        String tipo = item.getTipo();
        switch (tipo) {
            case "NORMAL":
                return new NormalItem(item);
            case "AGED BRIE":
                return new AgedBrie(item);
            case "SULFURAS":
                return new Sulfuras(item);
            case "CONJURED ITEM":
                return new ConjuredItem(item);
            case "BACKSTAGE PASS":
                return new BackstagePass(item);
            default:
                return null;
        }

    }

}
