module AnimalShelter {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires java.xml.bind;
    requires mysql.connector.java;
    requires javassist;
    requires org.hibernate.orm.core;
    requires net.bytebuddy;


    opens ui;
    exports  ui;
    exports  models;

}