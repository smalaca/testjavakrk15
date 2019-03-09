package com.smalaca;

public class Person {
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
        firstName = "";
        lastName = "";
    }

    public boolean hasFullName() {
        return !"".equals(firstName) && !"".equals(lastName);
    }

    public String fullName() {
        return firstName + " " + lastName;
    }
}
