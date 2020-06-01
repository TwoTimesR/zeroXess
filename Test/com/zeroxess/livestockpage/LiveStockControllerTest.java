package com.zeroxess.livestockpage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiveStockControllerTest {

    TextField nameCompany;
    TextField typeAnimal;
    TextField nameAnimal;
    TextField weight;
    TextField age;
    TextField price;



    @Test
    void getGraphic() {
        ObservableList<Animal> animals = FXCollections.observableArrayList();

        animals.add(new Animal("Project1","pig","Frank",55,4,440.69));
        assertTrue(animals.contains("Frank"));
    }

    @Test
    void onAddButtonCLicked() {
        ObservableList<Animal> animals = FXCollections.observableArrayList();
        nameCompany.setText("Testa");
        typeAnimal.setText("cow?");
        nameAnimal.setText("Answers!");
        weight.setText("88");//input should be double
        age.setText("5");
        price.setText("5");

        assertTrue(animals.contains("testa"));
    }

}