package com.zeroxess.medical;

import com.zeroxess.Utilities;
import com.zeroxess.user.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AllAppointmentsController {

    @FXML
    private GridPane pane;

    @FXML
    private ListView<String> allAppointmentsView;

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/zeroxess/medical/AllAppointments.fxml"));
        Scene scene =  new Scene(root, 800 ,600);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        ObservableList<String> app = FXCollections.observableArrayList();
        for(Appointment[] appointments : UserManager.getInstance().getLoggedInUser().getCalendar().getAppointments()) {
            for(Appointment ap : appointments) {
                if(ap != null) {
                    System.out.println(ap);
                    app.add(ap.getAppointmentDataString());
                }
            }
        }
        allAppointmentsView.setItems(app);
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Utilities.openAppointmentScreen(pane);
    }
}
