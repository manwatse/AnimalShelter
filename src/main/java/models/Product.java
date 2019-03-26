package models;

import interfaces.ISellable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")

public class Product implements ISellable {

    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "Price")
    private double price;



    public Product(int id, String name, double price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getStock() {
        return 0;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString(){
        return id + ", "+name + ", $" + getPrice() ;
    }
}


