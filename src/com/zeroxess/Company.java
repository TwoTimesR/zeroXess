package com.zeroxess;

public class Company {
    private String name;
    private String eMail;
    private String phoneNumber;

    public Company(String name, String eMail, String phoneNumber) {
        this.name = name;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return (this.name+ " " + this.eMail + " " + this.phoneNumber);
    }
}
