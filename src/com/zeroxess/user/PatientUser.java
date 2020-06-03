package com.zeroxess.user;

import com.zeroxess.medical.Calendar;

public class PatientUser extends User {

    private String healthCondtions;

    public PatientUser(String username, String password, UserProfile userProfile) {
        super(username, password, userProfile);
    }

    public String getHealthCondtions() {
        return healthCondtions;
    }

    public void setHealthCondtions(String healthCondtions) {
        this.healthCondtions = healthCondtions;
    }
}
