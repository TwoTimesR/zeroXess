package com.zeroxess.contactspage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactsControllerTest {
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

    @Test
    public void initialize() {
    }

    @Test
    public void saveButtonAction() {
        ObservableList<Person> persons = FXCollections.observableArrayList();

        personOrCompany.setValue("person");
        firstNameField.setText("Test");
        surnameField.setText("Naam");
        emailField.setText("test@mail.nl");
        phoneNumberField.setText("1234");
        saveButtonAction();
        assertTrue(persons.contains("Test"));
    }

    @Test
    public void changeForm(){
        firstNameLabel.setVisible(true);
        changeForm();
        assertFalse(firstNameLabel.isVisible());
    }
}