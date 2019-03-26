package models;

import enums.ObjectList;
import interfaces.ISellable;

import javax.persistence.*;
import java.util.Date;




@MappedSuperclass
@Table(name = "animal")
public abstract class Animal implements ISellable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", updatable = false, nullable = false)
    private int id;

    @Column(name = "Name", updatable = false, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Object",length = 8)
    private ObjectList objectList;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender",length = 8, nullable = true)
    private Gender gender;

    @Column(name = "Reservor", updatable = true, nullable = true)
    private String reservor;
    @Column(name = "Reservordate", updatable = true, nullable = true)
    private Date reserverDate;


    Animal (int id, String name, Gender gender, ObjectList object){
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.objectList = object;
    }

    public Boolean reserveIfPossible (String reserveBy){
        if (reservor == null){
            reservor=reserveBy;
            reserverDate= new Date();

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
        if (reservor != null){
            reserved = "reserved by " + reservor+"at "+reserverDate;
        }
        return id + ", " + name + ", " + gender.toString() + ", " + reserved;
    }
}
