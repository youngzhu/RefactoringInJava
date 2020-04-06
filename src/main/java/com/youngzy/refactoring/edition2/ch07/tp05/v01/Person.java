package com.youngzy.refactoring.edition2.ch07.tp05.v01;

public class Person {
    private String name;
    private String officeAreaCode;
    private String officeNumber;

    private transient TelephoneNumber telephoneNumber;

    public Person(String name, String officeAreaCode, String officeNumber) {
        this.name = name;
        this.officeAreaCode = officeAreaCode;
        this.officeNumber = officeNumber;

        telephoneNumber = new TelephoneNumber(officeAreaCode, officeNumber);
    }

    public String getTelephoneNumber() {
//        return this.officeAreaCode + "-" + this.officeNumber;
        return telephoneNumber.toString();
    }
}
