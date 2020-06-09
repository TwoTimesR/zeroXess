package com.zeroxess.medical;

import com.zeroxess.user.DoctorUser;
import com.zeroxess.user.PatientUser;
import com.zeroxess.user.User;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Appointment {

    private DoctorUser practitioner;
    private User patient;
    private LocalTime startTime;
    private LocalTime endTime;
    private int timeIndex;

    public Appointment(DoctorUser practitioner, User patient, LocalTime startTime, LocalTime endTime, int timeIndex) {
        this.practitioner = practitioner;
        this.patient = patient;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeIndex = timeIndex;
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
        return startTime.toString() +" - "+ endTime.toString() + " Doctor: " + practitioner.getUserProfile().getLastName();
    }

    @Override
    public String toString() {
        return startTime.toString() +" - "+ endTime.toString();
    }
}
