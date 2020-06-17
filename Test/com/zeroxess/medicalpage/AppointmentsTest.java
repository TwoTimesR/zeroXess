package com.zeroxess.educationpage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentsTest {

    @Test
    public void appointmentsAvailible() {
        DoctorUser currentSelectedDoctor = new DoctorUser("jan", "yo", new UserProfile("Jan", "Sloot"), DoctorUser.DoctorSpecialization.EAR, DoctorUser.DoctorSpecialization.GENERAL);
        PatientUser patient = new PatientUser("yoo", "test", new UserProfile("Piet", "Patient"));
        LocalDate newDate = LocalDate.now();
        Appointment[] appointments = currentSelectedDoctor.getCalendar().getAppointments()[newDate.getDayOfYear()];
        LocalTime time = LocalTime.of(9, 0);
        //Make an appointment on every timeslot of the day
        for (int i = 0; i < appointments.length; i++) {
            Appointment appointment = new Appointment(currentSelectedDoctor, patient, time, time = time.plusMinutes(30), i, newDate);
            currentSelectedDoctor.getCalendar().getAppointments()[newDate.getDayOfYear()][i] = appointment;
        }

        //Check if there is appointments left on this day
        boolean hasAvailible = hasTimeSlot(newDate, currentSelectedDoctor);

        assertFalse(hasAvailible);
    }
}