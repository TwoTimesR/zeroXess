package com.zeroxess.condition;

import com.zeroxess.Utilities;
import com.zeroxess.user.DoctorUser;
import com.zeroxess.user.PatientUser;
import com.zeroxess.user.UserManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ConditionController {

    @FXML
    private AnchorPane pane;

    @FXML
    private ListView<PatientUser> patientsListView;

    @FXML
    private ListView<DoctorUser.DoctorSpecialization> conditionTypeListView;

    @FXML
    private Label conditionType;

    @FXML
    private TextArea conditionDescription;

    @FXML
    private TextArea PatientConditionDescription;

    @FXML
    private ListView<Condition> PatientConditionListView;

    @FXML
    private Label patientConditionDoctor;

    public void initialize() {
        PatientConditionDescription.setEditable(false);

        ObservableList<PatientUser> patients = FXCollections.observableArrayList();
        for (PatientUser patientUser : UserManager.getInstance().getPatients()) {
            patients.add(patientUser);
        }
        patientsListView.setItems(patients);

        ObservableList<DoctorUser.DoctorSpecialization> conditions = FXCollections.observableArrayList();
        for (DoctorUser.DoctorSpecialization condition : ((DoctorUser)UserManager.getInstance().getLoggedInUser()).getSpecializations()) {
            conditions.add(condition);
        }
        conditionTypeListView.setItems(conditions);
    }

    public void confirmCondition(ActionEvent actionEvent){
        DoctorUser doctor = (DoctorUser) UserManager.getInstance().getLoggedInUser();
        PatientUser patient = patientsListView.getSelectionModel().getSelectedItem();
        DoctorUser.DoctorSpecialization type = conditionTypeListView.getSelectionModel().getSelectedItem();
        String desc = conditionDescription.getText();

        Condition condition = new Condition(doctor, patient, desc, type);
        patient.addHealthCondition(condition);
        clear();
    }

    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Utilities.openHomeScreen(pane);
    }

    public void patientConditions(javafx.scene.input.MouseEvent mouseEvent) {
        ObservableList<Condition> cons = FXCollections.observableArrayList();
        PatientUser patient = patientsListView.getSelectionModel().getSelectedItem();
        for (Condition con : patient.getHealthConditions()) {
            cons.add(con);
        }
        PatientConditionListView.setItems(cons);
        clearPatientConditionDescription();
    }

    public void showPatientConditionDescription(MouseEvent mouseEvent) {
        String desc = PatientConditionListView.getSelectionModel().getSelectedItem().getDescription();
        PatientConditionDescription.setText(desc);
        patientConditionDoctor.setText(PatientConditionListView.getSelectionModel().getSelectedItem().getDoctor().toString());
    }

    public void clearPatientConditionDescription(){
        PatientConditionDescription.setText("");
        patientConditionDoctor.setText("");
    }

    public void clearConditionDescription(){
        conditionDescription.setText("");
    }

    public void clearPatientConditions(){
        PatientConditionListView.setItems(FXCollections.observableArrayList());
    }

    public void clear(){
        clearPatientConditionDescription();
        clearConditionDescription();
        clearPatientConditions();
    }
}
