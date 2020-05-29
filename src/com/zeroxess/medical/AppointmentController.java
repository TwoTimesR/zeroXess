package com.zeroxess.medical;

import com.zeroxess.Utilities;
import com.zeroxess.user.DoctorUser;
import com.zeroxess.user.PatientUser;
import com.zeroxess.user.UserProfile;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class AppointmentController {

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

    private static PatientUser patient = new PatientUser("yoo", "test", new UserProfile("Piet", "Patient"));

    public void initialize() {
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

        allDoctors.add(new DoctorUser("jan", "yo", new UserProfile("Jan", "Sloot"), DoctorUser.DoctorSpecialization.EAR));
        allDoctors.add(new DoctorUser("frans", "yo", new UserProfile("Frans", "Gast"), DoctorUser.DoctorSpecialization.NOSE));

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
                Appointment appointment = new Appointment(currentSelectedDoctor, patient, time, time = time.plusMinutes(30), i);
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
        patient.getCalendar().getAppointments()[dayOfAppointment][indexForTime] = selectedAppointment;

        int idx = timesListView.getSelectionModel().getSelectedIndex();
        availibleAppointments.set(idx, null);

        Utilities.showDialog(Alert.AlertType.INFORMATION, "Success", "Appointment has been added to your calendar!");
    }

}
