package com.youngzy.refactoring.edition1.ch08.tp16.v03;

public abstract class EmployeeType {
    abstract int getTypeCode();

    public static EmployeeType newType(int code) {
        switch (code) {
            case ENGINEER:
                return new Engineer();
            case SALESMAN:
                return new Salesman();
            case MANAGER:
                return new Manager();
            default:
                throw new RuntimeException("Incorrect Employee Code");
        }
    }

    abstract int payAmount(Employee employee);

    public static final int ENGINEER = 0;
    public static final int SALESMAN = 1;
    public static final int MANAGER = 2;
}
