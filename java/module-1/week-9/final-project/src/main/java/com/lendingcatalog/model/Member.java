package com.lendingcatalog.model;

public class Member {
    private String firstName;
    private String lastName;

    //Constructor

    public Member (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //getters
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    //Methods:

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
