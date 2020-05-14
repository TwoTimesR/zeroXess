package com.zeroxess;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Utilities {

    public static void openHomeScreen(Pane currentPane) throws IOException {
        Stage stage = (Stage) currentPane.getScene().getWindow();
        Parent root = FXMLLoader.load(Main.class.getResource("/com/zeroxess/homepage/homepage.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }

}
