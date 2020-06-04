package com.zeroxess.condition;

import com.zeroxess.user.DoctorUser;
import com.zeroxess.user.PatientUser;

import java.util.ArrayList;

public class Condition {

    protected static ArrayList<Condition> conditions = new ArrayList<Condition>();

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

    protected static void addCondition(Condition condition){
        Condition.conditions.add(condition);
    }

    protected static ArrayList<Condition> getConditions(){
        return Condition.conditions;
    }

    protected static ArrayList<Condition> getConditions(PatientUser patient){
        ArrayList<Condition> a = new ArrayList<Condition>();

        for(Condition con : Condition.getConditions()){
            if(con.getPatient().equals(patient)){
                a.add(con);
            }
        }

        return a;
    }

    protected static ArrayList<Condition> getConditions(DoctorUser doctor){
        ArrayList<Condition> a = new ArrayList<Condition>();

        for(Condition con : Condition.getConditions()){
            if(con.getDoctor().equals(doctor)){
                a.add(con);
            }
        }

        return a;
    }

    @Override
    public String toString() {
        return condition.toString();
    }

}