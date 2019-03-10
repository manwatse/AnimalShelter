package models;

import enums.ObjectList;

public class Cat extends Animal {
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
}
