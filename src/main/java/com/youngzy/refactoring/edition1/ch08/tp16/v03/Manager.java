package com.youngzy.refactoring.edition1.ch08.tp16.v03;

public class Manager extends EmployeeType {
    @Override
    int getTypeCode() {
        return MANAGER;
    }

    @Override
    public int payAmount(Employee employee) {
        return employee.getMonthlySalary() + employee.getBonus();
    }
}
