package com.example.mockitohw.demo;


import com.example.mockitohw.demo.employee.Employee;

import com.example.mockitohw.demo.employeeService.EmployeeServiceIml;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.doReturn;

public class EmployeeServiceTest {

    private final EmployeeServiceIml employeeServiceIml = new EmployeeServiceIml();

    @BeforeEach
    void setUp() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", 5000));
        employees.add(new Employee(2, "Alice",6000));

    }

    @Test
    public void testAddEmployee() {
        EmployeeServiceIml employeeService = new EmployeeServiceIml();
        Employee employee = new Employee(1, "John", 5000);
        employeeService.addEmployee(employee);
        assertEquals(employeeService.getAllEmployeeInDepartment("John"), 1);
    }

    @Test
    public void testRemoveEmployee() {
        Employee employee1 = new Employee(1, "John", 5000);
        employeeServiceIml.addEmployee(employee1);
        employeeServiceIml.removeEmployee(employee1);

    }

    @Test
    public void testSearchEmployeeByName() {
        Employee employee1 = new Employee(2, "Alex", 3000);
        employeeServiceIml.addEmployee(employee1);
        Employee foundEmployee = employeeServiceIml.searchEmployeeByName("Alex");
        assertEquals(foundEmployee, employee1);
    }

    @Test
    void testGetAllEmployeeInDepartment() {
        List<Employee> salesEmployees = employeeServiceIml.getAllEmployeeInDepartment("John");
        assertEquals(1, salesEmployees.size());
    }

    @Test
    void testGetTotalSalaryForDepartment() {
        String departmentName = "John";
        int totalSalesSalary = employeeServiceIml.getTotalSalary(departmentName);
        assertEquals(5000, totalSalesSalary);
    }

    @Test
    void testGetEmployeeWithMaxSalary() {
        EmployeeServiceIml spy; // в заблуждении я
//        doReturn(employeeServiceIml).when(spy).getAllEmployeeInDepartment("John");
// в заблуждении я
//        Employee maxSalaryEmployee = spy.getEmployeeWithMaxSalary("John");
//        assertEquals("John", maxSalaryEmployee.getEmployees());
    }// в заблуждении я


    @Test
    void testGetEmployeeWithMaxSalaryWhenEmpty() {
        List<Employee> emptyEmployees = new ArrayList<>();
        EmployeeServiceIml emptyEmployeeService = new EmployeeServiceIml();
        Employee employee = emptyEmployeeService.getEmployeeWithMaxSalary("John");
        assertNull(employee);
    }

}
