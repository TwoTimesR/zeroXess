package com.zeroxess.user;

import com.zeroxess.condition.Condition;

import java.util.ArrayList;

public class PatientUser extends User {

    private ArrayList<Condition> healthConditions;

    public PatientUser(String username, String password, UserProfile userProfile) {
        super(username, password, userProfile);
        healthConditions = new ArrayList<Condition>();
    }

    public ArrayList<Condition> getHealthConditions() {
        return healthConditions;
    }

    public void addHealthCondition(Condition healthCondition) {
        this.healthConditions.add(healthCondition);
    }

    @Override
    public String toString() {
        return getUserProfile().getFirstName()+" "+getUserProfile().getLastName();
    }
}
