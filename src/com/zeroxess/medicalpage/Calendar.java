package com.zeroxess.medicalpage;

public class Calendar {

    private Appointment[][] appointments;

    public Calendar() {
        appointments = new Appointment[365][16];
    }

    public Appointment[][] getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment[][] appointments) {
        this.appointments = appointments;
    }
}
