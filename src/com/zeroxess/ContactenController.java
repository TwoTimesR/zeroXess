package com.zeroxess;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ContactenController {

    @FXML
    private ChoiceBox<String> personOrCompany;
    @FXML
    private Label firstNameLabel;
    @FXML
    private TextField firstNameField;
    @FXML
    private Label surnameLabel;
    @FXML
    private TextField surnameField;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField emailField;
    @FXML
    private Label phoneNumberLabel;
    @FXML
    private TextField phoneNumberField;

    public void initialize() {
        personOrCompany.getSelectionModel()
                .selectedItemProperty()
                .addListener( (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    if(newValue.equals("company")){
                        changeForm();
                    }
                    else if(newValue.equals("person")){
                        changeForm();
                    }
                });
    }

    private void changeForm() {
        if(firstNameLabel.isVisible()){
            firstNameLabel.setVisible(false);
            firstNameField.setVisible(false);
            surnameLabel.setVisible(false);
            surnameField.setVisible(false);
            emailLabel.setVisible(false);
            emailField.setVisible(false);
            phoneNumberLabel.setVisible(false);
            phoneNumberField.setVisible(false);
        }
        else{
            firstNameLabel.setVisible(true);
            firstNameField.setVisible(true);
            surnameLabel.setVisible(true);
            surnameField.setVisible(true);
            emailLabel.setVisible(true);
            emailField.setVisible(true);
            phoneNumberLabel.setVisible(true);
            phoneNumberField.setVisible(true);
        }
    }


    public void saveButtonAction(ActionEvent actionEvent){
        //TODO: save contact or company in arraylist
    }

}
