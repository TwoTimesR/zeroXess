package com.zeroxess.medical;

import com.zeroxess.Utilities;
import com.zeroxess.livestockpage.LiveStockController;
import com.zeroxess.user.DoctorUser;
import com.zeroxess.user.PatientUser;
import com.zeroxess.user.UserManager;
import com.zeroxess.user.UserProfile;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class AppointmentController {

    @FXML
    private AnchorPane pane;

    @FXML
    private RadioButton eyeRadioButton;

    @FXML
    private RadioButton noseRadioButton;

    @FXML
    private RadioButton earRadioButton;

    @FXML
    private RadioButton skinRadioButton;

    @FXML
    private RadioButton generalRadioButton;

    @FXML
    private ListView<DoctorUser> doctorsListView;

    @FXML
    private ListView<Appointment> timesListView;

    @FXML
    private DatePicker datePicker;

    private ArrayList<DoctorUser> allDoctors = new ArrayList<>();
    private ObservableList<DoctorUser> displayedDoctors = FXCollections.observableArrayList();
    private ObservableList<Appointment> availibleAppointments = FXCollections.observableArrayList();

    public void initialize() {
        allDoctors.addAll(UserManager.getInstance().getDoctors());

        ToggleGroup group = new ToggleGroup();
        eyeRadioButton.setToggleGroup(group);
        noseRadioButton.setToggleGroup(group);
        earRadioButton.setToggleGroup(group);
        skinRadioButton.setToggleGroup(group);
        generalRadioButton.setToggleGroup(group);

        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {
            if (group.getSelectedToggle() != null) {
                RadioButton button = (RadioButton) group.getSelectedToggle();
                switch (button.getText()) {
                    case "Eye":
                        filterDoctorsBySpecialization(DoctorUser.DoctorSpecialization.EYE);
                        break;
                    case "Nose":
                        filterDoctorsBySpecialization(DoctorUser.DoctorSpecialization.NOSE);
                        break;
                    case "Ear":
                        filterDoctorsBySpecialization(DoctorUser.DoctorSpecialization.EAR);
                        break;
                    case "Skin":
                        filterDoctorsBySpecialization(DoctorUser.DoctorSpecialization.SKIN);
                        break;
                    case "General":
                        filterDoctorsBySpecialization(DoctorUser.DoctorSpecialization.GENERAL);
                        break;
                }
            }
        });

        doctorsListView.setItems(displayedDoctors);
        timesListView.setItems(availibleAppointments);

        datePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty ||
                        date.compareTo(today) < 0 ||
                        date.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                        date.getDayOfWeek().equals(DayOfWeek.SUNDAY) ||
                        !hasTimeSlot(date));
            }

            private boolean hasTimeSlot(LocalDate date) {
                DoctorUser currentSelectedDoctor = doctorsListView.getSelectionModel().getSelectedItem();
                if (currentSelectedDoctor != null) {
                    Appointment[] appointments = currentSelectedDoctor.getCalendar().getAppointments()[date.getDayOfYear()];
                    for (Appointment a : appointments) {
                        if (a == null) {
                            return true;
                        }
                    }
                }
                return false;
            }
        });

        datePicker.valueProperty().addListener((observable, oldDate, newDate)->{
            DoctorUser currentSelectedDoctor = doctorsListView.getSelectionModel().getSelectedItem();
            if (currentSelectedDoctor != null) {
                displayTimesAvailibleOnDay(currentSelectedDoctor, newDate);
            }
        });

        timesListView.setCellFactory(new Callback<ListView<Appointment>, ListCell<Appointment>>() {

            @Override
            public ListCell<Appointment> call(ListView<Appointment> param) {
                ListCell<Appointment> cell = new ListCell<Appointment>() {

                    @Override
                    protected void updateItem(Appointment item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.toString());
                        } else {
                            setText("Time slot taken");
                        }
                    }
                };
                return cell;
            }
        });


    }

    private void filterDoctorsBySpecialization(DoctorUser.DoctorSpecialization specialization) {
        ObservableList<DoctorUser> filteredDoctors = FXCollections.observableArrayList();
        for (DoctorUser doctorUser : allDoctors) {
            if (doctorUser.getSpecializations().contains(specialization)) {
                filteredDoctors.add(doctorUser);
            }
        }
        displayedDoctors.setAll(filteredDoctors);
    }

    private void displayTimesAvailibleOnDay(DoctorUser currentSelectedDoctor, LocalDate newDate) {
        Appointment[] appointments = currentSelectedDoctor.getCalendar().getAppointments()[newDate.getDayOfYear()];
        LocalTime time = LocalTime.of(9, 0);
        Appointment[] availbileAppointments = appointments.clone();

        for (int i = 0; i < appointments.length; i++) {
            if (appointments[i] == null) {
                Appointment appointment = new Appointment(currentSelectedDoctor, UserManager.getInstance().getLoggedInUser(), time, time = time.plusMinutes(30), i, newDate);
                availbileAppointments[i] = appointment;
            } else {
                availbileAppointments[i] = null;
            }
        }
        availibleAppointments.setAll(availbileAppointments);

    }

    public void confirmAppointment() {
        Appointment selectedAppointment = timesListView.getSelectionModel().getSelectedItem();

        int dayOfAppointment = datePicker.getValue().getDayOfYear();
        int indexForTime = selectedAppointment.getTimeIndex();

        selectedAppointment.getPractitioner().getCalendar().getAppointments()[dayOfAppointment][indexForTime] = selectedAppointment;
        UserManager.getInstance().getLoggedInUser().getCalendar().getAppointments()[dayOfAppointment][indexForTime] = selectedAppointment;

        UserManager.getInstance().getLoggedInUser().setUpcomingAppointments(selectedAppointment.getAppointmentDataString());

        int idx = timesListView.getSelectionModel().getSelectedIndex();
        availibleAppointments.set(idx, null);

        Utilities.showDialog(Alert.AlertType.INFORMATION, "Success", "Appointment has been added to your calendar!");
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Utilities.openHomeScreen(pane);
    }

    public void goToAllAppointments(ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        new LiveStockController().start(stage);
    }
}
