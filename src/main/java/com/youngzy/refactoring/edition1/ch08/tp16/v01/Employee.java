package com.youngzy.refactoring.edition1.ch08.tp16.v01;

public class Employee {
    public static final int ENGINEER = 0;
    public static final int SALESMAN = 1;
    public static final int MANAGER = 2;

    private EmployeeType type;
    private int monthlySalary;
    private int commission;  // 佣金
    private int bonus;  // 额外津贴

    public Employee(int type) {
        setType(type);

        // 为了方便测试
        monthlySalary = 3000;
        commission = 500;
        bonus = 5000;
    }

    public int payAmount() {
        switch (getType()) {
            case ENGINEER:
                return monthlySalary;
            case SALESMAN:
                return monthlySalary + commission;
            case MANAGER:
                return monthlySalary + bonus;
            default:
                throw new RuntimeException("Incorrect Employee");
        }
    }

    public int getType() {
        return type.getTypeCode();
    }

    public void setType(int type) {
        switch (type) {
            case ENGINEER:
                this.type = new Engineer();
                break;
            case SALESMAN:
                this.type = new Salesman();
                break;
            case MANAGER:
                this.type = new Manager();
                break;
            default:
                throw new RuntimeException("Incorrect Employee Code");
        }
    }
}
