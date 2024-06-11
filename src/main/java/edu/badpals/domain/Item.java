package edu.badpals.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table (name = "TABLA_ITEMS")
public class Item extends PanacheEntityBase {

    @Id
    @Column (name = "ID")
    public int id;

    @Column (name = "NOMBRE")
    public String name;

    @Column (name = "SELL_IN")
    public int sellIn;

    @Column (name = "QUALITY")
    public int quality;

    @Column (name = "TIPO")
    public String tipo;

    public Item(String name, int sellIn, int quality, String tipo) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.tipo = tipo;
    }

    public Item() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sellIn=" + sellIn +
                ", quality=" + quality +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public static List<Item> getEveryItem(){
        return Item.listAll();
    }
}