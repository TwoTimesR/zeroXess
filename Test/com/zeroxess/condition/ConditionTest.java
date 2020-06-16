package com.zeroxess.condition;

import com.sun.prism.paint.RadialGradient;
import com.zeroxess.user.DoctorUser;
import com.zeroxess.user.PatientUser;
import com.zeroxess.user.UserManager;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ConditionTest {

    ArrayList<Condition> conditions = new ArrayList<Condition>();

    @Before
    public void init() {
        new UserManager();

        //Patient #1: Piet Patient
        //Patient #2: Peter Patient
        //Doctor #1: Jan Sloot
        //Doctor #2: Frans Gast
        for(int i = 0; i < 2; i++){
            PatientUser patient = UserManager.getInstance().getPatients().get(i);
            DoctorUser doctor = UserManager.getInstance().getDoctors().get(i);
            int rand = new Random().nextInt(5);
            DoctorUser.DoctorSpecialization specialization = DoctorUser.DoctorSpecialization.values()[rand];
            String description = "";
            if(rand % 2 == 0){
                description = "infection";
            }else{
                description = "injury";
            }
            Condition con = new Condition(doctor, patient, "", specialization);
            conditions.add(con);
        }
    }

    @Test
    void getPatient() {
        for(int i = 0; i < conditions.size(); i++){
            Condition con = conditions.get(i);
            switch(i) {
                case 0:
                    //Piet Patient
                    assertEquals(con.getPatient(), UserManager.getInstance().getPatients().get(i));
                    assertEquals(con.getPatient().getUserProfile().getFirstName(), "Piet");
                    assertEquals(con.getPatient().getUserProfile().getLastName(), "Patient");
                    break;
                case 1:
                    //Peter Patient
                    assertEquals(con.getPatient(), UserManager.getInstance().getPatients().get(i));
                    assertEquals(con.getPatient().getUserProfile().getFirstName(), "Peter");
                    assertEquals(con.getPatient().getUserProfile().getLastName(), "Patient");
                    break;
                default:
                    // code block
            }
        }
    }

    @Test
    void getDoctor() {
        for (int i = 0; i < conditions.size(); i++) {
            Condition con = conditions.get(i);
            switch (i) {
                case 0:
                    //Jan Sloot
                    assertEquals(con.getDoctor(), UserManager.getInstance().getDoctors().get(i));
                    assertEquals(con.getDoctor().getUserProfile().getFirstName(), "Jan");
                    assertEquals(con.getDoctor().getUserProfile().getLastName(), "Sloot");
                    break;
                case 1:
                    //Frans Gast
                    assertEquals(con.getDoctor(), UserManager.getInstance().getDoctors().get(i));
                    assertEquals(con.getDoctor().getUserProfile().getFirstName(), "Frans");
                    assertEquals(con.getDoctor().getUserProfile().getLastName(), "Gast");
                    break;
                default:
                    // code block
            }
        }
    }
}