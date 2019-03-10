package models;

import interfaces.ISellable;

public class Product implements ISellable {
    private String name;
    private double price;
    private int id;

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
    public int getId() {
        return this.id;
    }
}
