package com.youngzy.refactoring.edition1.ch08.tp16.v03;

public class Salesman extends EmployeeType {
    @Override
    int getTypeCode() {
        return SALESMAN;
    }

    @Override
    public int payAmount(Employee employee) {
        return employee.getMonthlySalary() + employee.getCommission();
    }
}
