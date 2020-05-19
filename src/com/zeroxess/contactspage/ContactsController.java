package com.zeroxess.contactspage;

import com.zeroxess.Utilities;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class ContactsController {
    public ObservableList<Company> companies = FXCollections.observableArrayList();
    public ObservableList<Person> persons = FXCollections.observableArrayList();

    
    @FXML    GridPane contactsPane;
    @FXML    private ChoiceBox<String> personOrCompany;
    @FXML    private Label firstNameLabel;
    @FXML    private TextField firstNameField;
    @FXML    private Label surnameLabel;
    @FXML    private TextField surnameField;
    @FXML    private Label emailLabel;
    @FXML    private TextField emailField;
    @FXML    private Label phoneNumberLabel;
    @FXML    private TextField phoneNumberField;
    @FXML    private Label companyNameLabel;
    @FXML    private TextField companyNameField;
    @FXML    private Label companyEmailLabel;
    @FXML    private TextField companyEmailField;
    @FXML    private Label companyPhoneLabel;
    @FXML    private TextField companyPhoneField;
    @FXML    private ListView contactsList;

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
            companyNameLabel.setVisible(true);
            companyNameField.setVisible(true);
            companyEmailLabel.setVisible(true);
            companyEmailField.setVisible(true);
            companyPhoneLabel.setVisible(true);
            companyPhoneField.setVisible(true);
            contactsList.setItems(companies);

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
            companyNameLabel.setVisible(false);
            companyNameField.setVisible(false);
            companyEmailLabel.setVisible(false);
            companyEmailField.setVisible(false);
            companyPhoneLabel.setVisible(false);
            companyPhoneField.setVisible(false);
            contactsList.setItems(persons);
        }
    }

    public void saveButtonAction(ActionEvent actionEvent){
        if(personOrCompany.getValue().equals("person")){
            String name = firstNameField.getText();
            String surname = surnameField.getText();
            String email = emailField.getText();
            String phone = phoneNumberField.getText();
            firstNameField.clear();
            surnameField.clear();
            emailField.clear();
            phoneNumberField.clear();
            persons.add(new Person(name,surname,email,phone));
            contactsList.setItems(persons);
        }

        else if(personOrCompany.getValue().equals("company")){
            String name = companyNameField.getText();
            String email = companyEmailField.getText();
            String phone = companyPhoneField.getText();
            companyNameField.clear();
            companyEmailField.clear();
            companyPhoneField.clear();
            companies.add(new Company(name,email,phone));
            contactsList.setItems(companies);
        }
    }

    public void backButtonAction(ActionEvent actionEvent) throws IOException {
        Utilities.openHomeScreen(contactsPane);
    }
}

