package com.youngzy.refactoring.edition1.ch08.tp16.v03;

public class Engineer extends EmployeeType {
    @Override
    int getTypeCode() {
        return ENGINEER;
    }

    @Override
    public int payAmount(Employee employee) {
        return employee.getMonthlySalary();
    }
}
