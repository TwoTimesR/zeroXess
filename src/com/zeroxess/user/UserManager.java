package com.zeroxess.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {

    private User loggedInUser = null;

    private static UserManager instance = new UserManager();

    private List<User> users = new ArrayList<>();

    public UserManager() {
    }

    public static UserManager getInstance() {
        return instance;
    }

    private List<User> getUsers() {
        return users;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public boolean successfulLogin(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                if (u.getPassword().equals(password)) {
                    //Username found correct password
                    this.loggedInUser = u;
                    return true;
                } else {
                    //Username found wrong password
                    return false;
                }
            }
        }
        //Username not found
        return false;
    }

    public List<DoctorUser> getDoctors() {
        return users.stream()
                .filter(sc -> sc instanceof DoctorUser)
                .map (sc -> (DoctorUser) sc)
                .collect(Collectors.toList());
    }

    public List<PatientUser> getPatients() {
        return users.stream()
                .filter(sc -> sc instanceof PatientUser)
                .map (sc -> (PatientUser) sc)
                .collect(Collectors.toList());
    }

    static {
        getInstance().getUsers().add(new PatientUser("yoo", "test", new UserProfile("Piet", "Patient")));
        getInstance().getUsers().add(new PatientUser("peter", "test", new UserProfile("Peter", "Patient")));
        getInstance().getUsers().add(new PatientUser("willem", "test", new UserProfile("Willem", "Wever")));
        getInstance().getUsers().add(new DoctorUser("jan", "yo", new UserProfile("Jan", "Sloot"), DoctorUser.DoctorSpecialization.EAR, DoctorUser.DoctorSpecialization.GENERAL));
        getInstance().getUsers().add(new DoctorUser("frans", "yo", new UserProfile("Frans", "Gast"), DoctorUser.DoctorSpecialization.NOSE));
        getInstance().getUsers().add(new PatientUser("vincent", "test", new UserProfile("Vincent", "test", "test","test","test")));
        getInstance().getUsers().add(new PatientUser("haidar", "test", new UserProfile("Haidar", "test", "test","test","test")));
        getInstance().getUsers().add(new PatientUser("aycan", "test", new UserProfile("Aycan", "test", "test","test","test")));
        getInstance().getUsers().add(new PatientUser("richal", "test", new UserProfile("Richal", "test", "test","test","test")));
        getInstance().getUsers().add(new PatientUser("tonio", "test", new UserProfile("Tonio", "test", "test","test","test")));
        getInstance().getUsers().add(new PatientUser("brent", "test", new UserProfile("Brent", "test", "test","test","test")));
    }
}
