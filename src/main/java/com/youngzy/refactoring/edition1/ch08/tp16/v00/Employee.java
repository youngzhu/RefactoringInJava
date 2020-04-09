package com.youngzy.refactoring.edition1.ch08.tp16.v00;

public class Employee {
    public static final int ENGINEER = 0;
    public static final int SALESMAN = 1;
    public static final int MANAGER = 2;

    private int type;
    private int monthlySalary;
    private int commission;  // 佣金
    private int bonus;  // 额外津贴

    public Employee(int type) {
        this.type = type;

        // 为了方便测试
        monthlySalary = 3000;
        commission = 500;
        bonus = 5000;
    }

    public int payAmount() {
        switch (type) {
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
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
