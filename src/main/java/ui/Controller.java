package ui;

import enums.ObjectList;
import interfaces.ISellable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import logic.Shelter;
import logic.WebShop;
import models.Animal;
import models.Gender;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class Controller implements Initializable {

    private Shelter shelter;
    private WebShop webShop;
    private int id = 0;

    //region FXML labels
    @FXML
    private Label nameLabel;

    @FXML
    private Label badHabbitsLabel;

    @FXML
    private Label reserverNameLabel;

    @FXML
    private Label reserveAnimalLabel;

    @FXML
    private  Label genderLabel;

    @FXML
    private Label animalListLabel;

    @FXML
    private  Label webshopListLabel;

    @FXML
    private Label priceLabel;

    //endregion

    //region FXML elements
    @FXML
    private ComboBox<ObjectList> spieciesCB;

    @FXML
    private TextField nameTB;

    @FXML
    private TextField reserverTB;

    @FXML
    private Button reserverBT;

    @FXML
    private TextField bhabbitsTB;

    @FXML
    private RadioButton maleRB;

    @FXML
    private RadioButton femaleRB;

    @FXML
    private ListView<Animal> animalsLV;

    @FXML
    private ListView<ISellable> lvWebShop;

    @FXML
    private Button btBuy;

    @FXML
    private TextField tbPrice;
    //endregion

    public void initialize(URL location, ResourceBundle resources) {
        spieciesCB.setItems(observableArrayList(ObjectList.CAT, ObjectList.DOG, ObjectList.ITEM));
        shelter = new Shelter();
        webShop = new WebShop();
        shelter.addObserver(webShop);

        nameLabel.setVisible(false);
        nameTB.setVisible(false);
        bhabbitsTB.setVisible(false);
        badHabbitsLabel.setVisible(false);

        genderLabel.setVisible(false);
        maleRB.setVisible(false);
        femaleRB.setVisible(false);

        animalListLabel.setVisible(false);
        animalsLV.setVisible(false);

        reserverTB.setVisible(false);
        reserverBT.setVisible(false);
        reserverNameLabel.setVisible(false);
        reserveAnimalLabel.setVisible(false);

        webshopListLabel.setVisible(false);
        priceLabel.setVisible(false);
        tbPrice.setVisible(false);
        lvWebShop.setVisible(false);
        btBuy.setVisible(false);
    }


    @FXML
    private void addAnimal() {
        if (spieciesCB.getValue() == ObjectList.CAT) {

            shelter.newCat(id, nameTB.getText(), maleRB.isSelected() ? Gender.MALE : Gender.FEMALE, bhabbitsTB.getText());
            refreshAnimalList();
        } else if (spieciesCB.getValue() == ObjectList.DOG) {
            shelter.newDog(id, nameTB.getText(), maleRB.isSelected() ? Gender.MALE : Gender.FEMALE);
            refreshAnimalList();
        } else {
            webShop.addNewProduct(id, nameTB.getText(), Double.parseDouble(tbPrice.getText()));
            ObservableList<ISellable> items = lvWebShop.getItems();
            items.clear();
            items.addAll(webShop.getObjects());
        }
        id++;
    }

    @FXML
    private void addReserver() {
        Animal ani = animalsLV.getSelectionModel().getSelectedItem();
        if (!ani.reserveIfPossible(reserverTB.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred");
            alert.setContentText("Someone reserved this animal already");
            alert.show();
        }
        animalsLV.refresh();
        lvWebShop.refresh();
    }

    @FXML
    private void speciesCBChange() {
        if (spieciesCB.getValue() != null) {

            nameLabel.setVisible(true);
            nameTB.setVisible(true);
            bhabbitsTB.setVisible(spieciesCB.getValue() == ObjectList.CAT);
            badHabbitsLabel.setVisible(spieciesCB.getValue() == ObjectList.CAT);

            genderLabel.setVisible(spieciesCB.getValue() != ObjectList.ITEM);
            maleRB.setVisible(spieciesCB.getValue() != ObjectList.ITEM);
            femaleRB.setVisible(spieciesCB.getValue() != ObjectList.ITEM);

            animalListLabel.setVisible(spieciesCB.getValue() != ObjectList.ITEM);
            animalsLV.setVisible(spieciesCB.getValue() != ObjectList.ITEM);

            reserverTB.setVisible(spieciesCB.getValue() != ObjectList.ITEM);
            reserverBT.setVisible(spieciesCB.getValue() != ObjectList.ITEM);
            reserverNameLabel.setVisible(spieciesCB.getValue() != ObjectList.ITEM);
            reserveAnimalLabel.setVisible(spieciesCB.getValue() != ObjectList.ITEM);

            webshopListLabel.setVisible(spieciesCB.getValue() == ObjectList.ITEM);
            priceLabel.setVisible(spieciesCB.getValue() == ObjectList.ITEM);
            tbPrice.setVisible(spieciesCB.getValue() == ObjectList.ITEM);
            lvWebShop.setVisible(spieciesCB.getValue() == ObjectList.ITEM);
            btBuy.setVisible(spieciesCB.getValue() == ObjectList.ITEM);

        }

    }

    private void refreshAnimalList (){
        ObservableList<Animal> animals = animalsLV.getItems();
        animals.clear();
        animals.addAll(shelter.getAnimals());

    }

}
