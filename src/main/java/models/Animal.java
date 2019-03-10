package models;

import enums.ObjectList;
import interfaces.ISellable;
import java.util.Date;

public abstract class Animal implements ISellable {

    private String name;
    private Gender gender;
    private Reservor reservedBy;
    private ObjectList objectList;
    private int id;

    Animal (int id, String name, Gender gender, ObjectList object){
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.objectList = object;
    }

    public Boolean reserveIfPossible (String reserveBy){
        if (reservedBy == null){
            reservedBy = new Reservor(reserveBy, new Date());
            return true;
        }
        return false;
    }

    public String getName(){
        return this.name;
    }

    public Gender getGender(){
        return this.gender;
    }

    public Reservor getReserver(){
        return this.reservedBy;
    }

    public ObjectList getObjectList(){
        return this.objectList;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        String reserved = "not reserved";
        if (reservedBy != null){
            reserved = "reserved by " + reservedBy.getReserver();
        }
        return id + ", " + name + ", " + gender.toString() + ", " + reserved;
    }
}
