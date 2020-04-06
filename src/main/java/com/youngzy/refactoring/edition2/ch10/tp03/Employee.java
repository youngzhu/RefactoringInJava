package com.youngzy.refactoring.edition2.ch10.tp03;

public class Employee {
    private String status;

    public Employee(String status) {
        this.status = status;
    }

    public boolean isDead() {
        return "dead".equals(status);
    }

    public boolean isSeparated() {
        return "separated".equals(status);
    }

    public boolean isRetired() {
        return "retired".equals(status);
    }
}
