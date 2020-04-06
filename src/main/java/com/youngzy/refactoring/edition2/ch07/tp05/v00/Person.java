package com.youngzy.refactoring.edition2.ch07.tp05.v00;

public class Person {
    private String name;
    private String officeAreaCode;
    private String officeNumber;

    public Person(String name, String officeAreaCode, String officeNumber) {
        this.name = name;
        this.officeAreaCode = officeAreaCode;
        this.officeNumber = officeNumber;
    }

    public String getTelephoneNumber() {
        return this.officeAreaCode + "-" + this.officeNumber;
    }
}
