package com.youngzy.refactoring.edition1.ch08.tp16.v02;

public class Employee {
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
            case EmployeeType.ENGINEER:
                return monthlySalary;
            case EmployeeType.SALESMAN:
                return monthlySalary + commission;
            case EmployeeType.MANAGER:
                return monthlySalary + bonus;
            default:
                throw new RuntimeException("Incorrect Employee");
        }
    }

    public int getType() {
        return type.getTypeCode();
    }

    public void setType(int type) {
        this.type = EmployeeType.newType(type);
    }


}
