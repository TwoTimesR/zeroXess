package com.zeroxess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

        //test stuff
        Label testLabel1 = new Label("This is a label");
        gridPane.add(testLabel1, 1, 1, 1, 1);

        TextField firstName = new TextField();
        gridPane.add(firstName, 1, 2, 1, 1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
