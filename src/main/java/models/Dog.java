package models;

import enums.ObjectList;

import java.util.Calendar;
import java.util.Date;

public class Dog extends Animal {

    private Calendar lastWalked = Calendar.getInstance();
    private static int totalDogs = 0;
    private double price;

    public Dog(int id, String name, Gender gender) {
        super(id, name, gender, ObjectList.DOG);
        this.lastWalked.setTime(new Date());
        calculatePrice();
        totalDogs++;
    }

    private void calculatePrice() {
        price = 500;
        price = price - totalDogs * 50;
        if (price < 50) price = 50;
    }

    public static void instantiateTotalDogs(int newTotalDogs) {
        totalDogs = newTotalDogs;
    }

    @Override
    public String toString() {
        return super.toString() + ", $" + this.price + ", last walk: " + lastWalked.getTime().toString();
    }

    @Override
    public double getPrice() {
        return price;
    }
}
