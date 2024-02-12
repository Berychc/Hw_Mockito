package com.example.mockitohw.demo;

import com.example.mockitohw.demo.employee.Employee;

import com.example.mockitohw.demo.employeeService.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static com.example.mockitohw.demo.employeeService.EmployeeTestConstant.EmployeeTestConstants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class EmployeeServiceTest {

    private final EmployeeService employeeService;

    public EmployeeServiceTest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @BeforeEach
    void setUp() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(DEPARTMENT_ID,FIRST_NAME,SALARY));
    }

    @Test
    void testGetTotalSalaryForDepartment() {
        employeeService.add(DEPARTMENT_ID,FIRST_NAME,SALARY);
        assertEquals(3000,SALARY);
    }

    @Test
    public void testAddEmployee() {
        employeeService.add(DEPARTMENT_ID,FIRST_NAME,SALARY);
        assertEquals("John",FIRST_NAME);
    }

    @Test
    public void testRemoveEmployee() {
        Employee expected = employeeService.add(DEPARTMENT_ID,FIRST_NAME,SALARY);

        assertEquals(1, employeeService.find(FIRST_NAME));

        Employee actual = employeeService.remove(FIRST_NAME);

        assertEquals(expected, actual);
    }

    @Test
    public void testSearchEmployeeByName() {
        employeeService.add(DEPARTMENT_ID,FIRST_NAME,SALARY);
        Employee foundEmployee = employeeService.find("John");
        assertEquals(foundEmployee, FIRST_NAME);
    }
    @Test
    void testGetAllEmployeeInDepartment() {

        Employee employee = employeeService.add(DEPARTMENT_ID, FIRST_NAME, SALARY);
        Employee employee1 = employeeService.add(DEPARTMENT_ID, FIRST_NAME1, SALARY);

        Collection<Employee> existed = List.of(employee, employee1);

        Collection<Employee> actual = employeeService.findAll();

        assertIterableEquals(existed, actual);
    }
}
