package com.example.mockitohw.demo;

import com.example.mockitohw.demo.employee.Employee;

import com.example.mockitohw.demo.employeeService.EmployeeServiceIml;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;


import static com.example.mockitohw.demo.employeeService.EmployeeTestConstant.EmployeeTestConstants.*;
import static junit.framework.TestCase.*;

public class EmployeeServiceTest {

    private final EmployeeServiceIml employeeServiceIml = new EmployeeServiceIml();

    @BeforeEach
    void setUp() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", 3000));
    }

    @Test
    void testGetTotalSalaryForDepartment() {
        Employee employee1 = new Employee(1, "John", 3000);
        employeeServiceIml.addEmployee(employee1);
        assertEquals(3000,SALARY);
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee(1, "John", 3000);
        employeeServiceIml.addEmployee(employee);
        assertEquals("John",FIRST_NAME);
    }

    @Test
    public void testRemoveEmployee() {
        List<Employee> employees;
        Employee employee1 = new Employee(1, "John", 3000);
        employeeServiceIml.addEmployee(employee1);
        employeeServiceIml.removeEmployee(employee1);
        assertFalse(employeeServiceIml.getEmployee(employee1));

    }

    @Test
    public void testSearchEmployeeByName() {
        Employee employee1 = new Employee(1, "John", 3000);
        employeeServiceIml.addEmployee(employee1);
        Employee foundEmployee = employeeServiceIml.searchEmployeeByName("John");
        assertEquals(foundEmployee, employee1);
    }
    @Test
    void testGetAllEmployeeInDepartment() {
        Employee employee1 = new Employee(1, "John", 3000);
        employeeServiceIml.addEmployee(employee1);
        List<Employee> employeesInDepartment1 = employeeServiceIml.getAllEmployeeInDepartment(DEPARTMENT_ID);
        assertEquals(1, employeesInDepartment1.size());
    }
}
