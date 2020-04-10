package com.youngzy.refactoring.edition1.ch08.tp16;

import com.youngzy.refactoring.edition1.ch08.tp16.v03.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void payAmountOfEngineer() {
        Employee employee = new Employee(EmployeeType.ENGINEER);

        assertEquals(3000, employee.payAmount());
    }

    @Test
    public void payAmountOfSalesman() {
        Employee employee = new Employee(EmployeeType.SALESMAN);

        assertEquals(3500, employee.payAmount());
    }

    @Test
    public void payAmountOfManager() {
        Employee employee = new Employee(EmployeeType.MANAGER);

        assertEquals(8000, employee.payAmount());
    }

    @Test
    public void payAmountOfEngineerToManager() {
        Employee employee = new Employee(EmployeeType.ENGINEER);

        assertEquals(3000, employee.payAmount());

        employee.setType(EmployeeType.MANAGER);
        assertEquals(8000, employee.payAmount());
    }
}