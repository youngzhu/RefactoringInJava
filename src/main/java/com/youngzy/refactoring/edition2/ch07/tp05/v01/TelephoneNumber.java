package com.youngzy.refactoring.edition2.ch07.tp05.v01;

public class TelephoneNumber {
    private String areaCode;
    private String number;

    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return this.areaCode + "-" + this.number;
    }
}
