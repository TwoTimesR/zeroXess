package com.zeroxess;

public class Person extends Contact{
    private String surname;

    public Person(String name, String surname, String eMail, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return (this.name + " " + this.surname + " " + this.eMail + " " + this.phoneNumber);
    }
}
