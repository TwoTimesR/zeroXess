package com.zeroxess.user;

import com.zeroxess.homepage.HomePageController;
import com.zeroxess.medical.Calendar;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {

    private String username;
    private String password;
    private UserProfile userProfile;
    private Calendar calendar;
    private ObservableList<String> upcomingAppointments = FXCollections.observableArrayList();

    public User(String username, String password, UserProfile userProfile) {
        this.username = username;
        this.password = password;
        this.userProfile = userProfile;
        this.calendar = new Calendar();

        upcomingAppointments.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                //new HomePageController().updateUpcomingAppointmentsList(upcomingAppointments);
            }
        });
    }

    public void setUpcomingAppointments(String upcoming){upcomingAppointments.add(upcoming);}

    public ObservableList<String> getUpcomingAppointments(){ return upcomingAppointments; }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
