package com.zeroxess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //profiel scherm test, om te kijken of het werkt.
        Parent root = FXMLLoader.load(getClass().getResource("ProfielScherm.fxml"));
        primaryStage.setTitle("zeroXess");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
//test van vincent
//test van Ayca
//test van Richal
//test van Tonio