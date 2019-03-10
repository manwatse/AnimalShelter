module AnimalShelter {
    requires javafx.controls;
    requires javafx.fxml;

    opens ui;
    exports  ui;
    exports  models;

}