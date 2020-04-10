package com.youngzy.refactoring.edition1.ch08.tp16;

import com.youngzy.refactoring.edition1.ch08.tp16.v02.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void payAmountOfEngineer() {
        Employee employee = new Employee(Employee.ENGINEER);

        assertEquals(3000, employee.payAmount());
    }

    @Test
    public void payAmountOfSalesman() {
        Employee employee = new Employee(Employee.SALESMAN);

        assertEquals(3500, employee.payAmount());
    }

    @Test
    public void payAmountOfManager() {
        Employee employee = new Employee(Employee.MANAGER);

        assertEquals(8000, employee.payAmount());
    }

    @Test
    public void payAmountOfEngineerToManager() {
        Employee employee = new Employee(Employee.ENGINEER);

        assertEquals(3000, employee.payAmount());

        employee.setType(Employee.MANAGER);
        assertEquals(8000, employee.payAmount());
    }
}