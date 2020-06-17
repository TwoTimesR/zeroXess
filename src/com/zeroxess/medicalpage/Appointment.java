package com.zeroxess.medicalpage;

import com.zeroxess.user.DoctorUser;
import com.zeroxess.user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private DoctorUser practitioner;
    private User patient;
    private LocalTime startTime;
    private LocalTime endTime;
    private int timeIndex;
    private LocalDate date;

    public Appointment(DoctorUser practitioner, User patient, LocalTime startTime, LocalTime endTime, int timeIndex, LocalDate date) {
        this.practitioner = practitioner;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeIndex = timeIndex;
        this.date = date;
    }

    public DoctorUser getPractitioner() {
        return practitioner;
    }

    public void setPractitioner(DoctorUser practitioner) {
        this.practitioner = practitioner;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getTimeIndex() {
        return timeIndex;
    }

    public void setTimeIndex(int timeIndex) {
        this.timeIndex = timeIndex;
    }

    public String getAppointmentDataString(){
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " - " + startTime.toString() +" - "+ endTime.toString() + " Doctor: " + practitioner.getUserProfile().getLastName();
    }

    @Override
    public String toString() {
        return startTime.toString() +" - "+ endTime.toString();
    }
}
