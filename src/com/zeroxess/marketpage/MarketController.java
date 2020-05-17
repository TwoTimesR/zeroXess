package com.zeroxess.marketpage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MarketController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane gridPane = new GridPane();
        Scene startScene = new Scene(gridPane, 800, 600);
        primaryStage.setScene(startScene);
        primaryStage.setTitle("Market");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
