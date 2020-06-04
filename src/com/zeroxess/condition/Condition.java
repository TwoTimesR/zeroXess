package com.zeroxess.condition;

import com.zeroxess.user.DoctorUser;
import com.zeroxess.user.PatientUser;

import java.util.ArrayList;

public class Condition {

    private DoctorUser doctor;
    private PatientUser patient;
    private DoctorUser.DoctorSpecialization condition;
    private String description;

    public Condition(DoctorUser doctor, PatientUser patient, String description, DoctorUser.DoctorSpecialization condition){
        this.doctor = doctor;
        this.patient = patient;
        this.condition = condition;
        this.description = description;
    }

    public PatientUser getPatient(){
        return this.patient;
    }

    public DoctorUser getDoctor(){
        return this.doctor;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString() {
        return condition.toString();
    }

}