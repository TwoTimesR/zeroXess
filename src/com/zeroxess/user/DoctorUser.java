package com.zeroxess.user;

import java.util.ArrayList;
import java.util.Arrays;

public class DoctorUser extends User {

    enum DoctorSpecialization {
        EYE,
        NOSE,
        EAR,
        SKIN,
        GENERAL
    }

    private ArrayList<DoctorSpecialization> specializations = new ArrayList<>();

    public DoctorUser(String username, String password, UserProfile userProfile, DoctorSpecialization... specializations) {
        super(username, password, userProfile);
        this.specializations.addAll(Arrays.asList(specializations));
    }
}
