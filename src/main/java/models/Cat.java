package models;

import enums.ObjectList;
import interfaces.ISellable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Cat")
public class Cat extends Animal implements ISellable {

    @Column(name = "badHabbits",nullable = true)
    private String badHabbits;

    public Cat(int id, String name, Gender gender, String badHabbits){
        super(id, name, gender, ObjectList.CAT);
        this.badHabbits = badHabbits;
    }

    @Override
    public String toString(){
        return super.toString() + ", $" + getPrice() + ", bad habits: " + badHabbits.toLowerCase();
    }

    @Override
    public double getPrice() {
        double price = 350;
        price = price - badHabbits.length() * 20;
        if (price < 35) return 35;
        return price;
    }

    @Override
    public int getStock() {
        return 0;
    }
}
