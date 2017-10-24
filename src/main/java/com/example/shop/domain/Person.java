package com.example.shop.domain;

public class Person {
    private String firstName = "unknown";

    public Person() {
        super();
    }

    public Person(String firstName) {
        super();
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
