package com.zeroxess.user;

import com.zeroxess.medical.Calendar;

public class PatientUser extends User {

    private Calendar calendar;

    private String healthCondtions;

    public PatientUser(String username, String password, UserProfile userProfile) {
        super(username, password, userProfile);
        this.calendar = new Calendar();
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public String getHealthCondtions() {
        return healthCondtions;
    }

    public void setHealthCondtions(String healthCondtions) {
        this.healthCondtions = healthCondtions;
    }
}
