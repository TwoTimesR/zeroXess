package com.zeroxess;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class ContactenController {
    ArrayList<Company> companies = new ArrayList<>();
    ArrayList<Person> persons = new ArrayList<>();
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
    @FXML
    private Label companyNameLabel;
    @FXML
    private TextField companyNameField;
    @FXML
    private Label companyEmailLabel;
    @FXML
    private TextField companyEmailField;
    @FXML
    private Label companyPhoneLabel;
    @FXML
    private TextField companyPhoneField;

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
        }
    }


    public void saveButtonAction(ActionEvent actionEvent){
        if(personOrCompany.getValue().equals("person")){
            String name = firstNameField.getText();
            String surname = surnameField.getText();
            String email = emailField.getText();
            String phone = phoneNumberField.getText();

            persons.add(new Person(name,surname,email,phone));
            for(Person person : persons){
                System.out.println(person.toString());
            }
        }
        else if(personOrCompany.getValue().equals("company")){
            String name = companyNameField.getText();
            String email = companyEmailField.getText();
            String phone = companyPhoneField.getText();

            companies.add(new Company(name,email,phone));
            for(Company company : companies){
                System.out.println(company.toString());
            }
        }
    }

}
