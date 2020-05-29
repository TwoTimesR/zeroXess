package com.zeroxess.medical;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

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
