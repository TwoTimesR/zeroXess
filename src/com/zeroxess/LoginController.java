package com.zeroxess;

import com.zeroxess.user.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Text messageField;

    public void initialize() {
        passwordField.setOnKeyPressed((event) -> { if(event.getCode() == KeyCode.ENTER) {
            try {
                loginButtonAction();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } });
    }

    public void loginButtonAction() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(UserManager.getInstance().successfulLogin(username, password)){
            messageField.setText("Login successful");
            Stage stage = (Stage) usernameField.getScene().getWindow();
            Parent root = FXMLLoader.load(Main.class.getResource("/com/zeroxess/homepage/homepage.fxml"));
            Scene scene =  new Scene(root, 800 ,600);
            stage.setScene(scene);
            stage.show();
        } else {
            messageField.setText("Login incorrect");
        }

    }
}
