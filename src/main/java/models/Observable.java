package models;

import interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyObservers(Object obj){
        for (Observer o :
                observers) {
            o.updateObject(obj);
        }
    }
}
