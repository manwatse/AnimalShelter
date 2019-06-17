package logic;


import enums.ObjectList;
import javafx.beans.InvalidationListener;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class Shelter extends Observable {
    private List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    //CatDAO catDAO = new CatDAO();
    //DogDAO dogDAO = new DogDAO();



    public void newCat(int id, String name, Gender gender, String badHabits) {
        Cat cat = new Cat(id, name, gender, badHabits);
        System.out.println("new cat");
        //catDAO.saveObject(cat);
        System.out.println("new cat");
        animals.add(cat);
        notifyObservers(cat);
    }

    public int totalCats() {
        int total = 0;
        for (Animal c :
                animals) {
            if (ObjectList.CAT == c.getObjectList()) total++;
        }
        return total;
    }

    public void newDog(int id, String name, Gender gender) {
        Dog dog = new Dog(id, name, gender);
       // dogDAO.saveObject(dog);
        animals.add(dog);
        notifyObservers(dog);
    }

    public int totalDogs() {
        int total = 0;
        for (Animal c :
                animals) {
            if (ObjectList.DOG == c.getObjectList()) total++;
        }
        return total;
    }
}
