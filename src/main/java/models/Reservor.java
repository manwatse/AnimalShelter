package models;

import java.util.Date;

public class Reservor {

    String name;
    Date date;

    public Reservor(String name, Date date) {
        this.name = name;
        this.date = date;
    }


    public String getReserver() {
        return name;
    }

    public Date getDate() {
        return date;
    }

}
