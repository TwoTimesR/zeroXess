package com.zeroxess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text messageField;

    public void initialize() {

    }

    public void loginButtonAction(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.equals("admin") && password.equals("Test")){
            messageField.setText("Login successful");
            //TODO: Send to next scene

        }else{
            messageField.setText("Login incorrect");
        }

    }
}
