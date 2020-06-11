package com.zeroxess.user;

import com.zeroxess.medical.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;

public class User {

    private String username;
    private String password;
    private UserProfile userProfile;
    private Calendar calendar;
    public ObservableList<String> upcomingAppointments = FXCollections.observableArrayList();

    public User(String username, String password, UserProfile userProfile) {
        this.username = username;
        this.password = password;
        this.userProfile = userProfile;
        this.calendar = new Calendar();
    }

    public void setUpcomingAppointments(String upcoming){upcomingAppointments.add(upcoming);}

    public ObservableList<String> getUpcomingAppointments(){
        Collections.sort(upcomingAppointments, new Comparator<String>() {
            DateFormat f = new SimpleDateFormat("dd-MM-yyyy - HH:mm");
            @Override
            public int compare(String s, String t1) {
                try {
                    return f.parse(s.substring(0,18)).compareTo(f.parse(t1.substring(0,18)));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
        if(upcomingAppointments.size() > 2) {
            for (int i = 2; i < upcomingAppointments.size(); i++) {
                upcomingAppointments.remove(i);
            }
        }
        return upcomingAppointments;
    }

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
