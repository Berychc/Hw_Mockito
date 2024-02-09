package com.example.mockitohw.demo;


import com.example.mockitohw.demo.employee.Employee;

import com.example.mockitohw.demo.employeeService.EmployeeServiceIml;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.*;


public class EmployeeServiceTest {

    private final EmployeeServiceIml employeeServiceIml = new EmployeeServiceIml();

    @BeforeEach
    void setUp() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", 5000));
    }

    @Test
    void testGetTotalSalaryForDepartment() {
        Employee employee1 = new Employee(2, "John", 3000);
        employeeServiceIml.addEmployee(employee1);
        int johnSalary = employeeServiceIml.getTotalSalary("John");
        assertEquals(3000,johnSalary);
    }

    @Test
    void testGetMaxSalary() {
        Employee employee1 = new Employee(1, "John", 3000);
        Employee employee2 = new Employee(2, "Bob", 4000);
        employeeServiceIml.addEmployee(employee1);
        employeeServiceIml.addEmployee(employee2);
        Employee maxSalaryEmployee = employeeServiceIml.getEmployeeWithMaxSalary("Bob");
        assertEquals("Bob", maxSalaryEmployee.getName());
    }

    @Test
    void testGetMixSalary() {
        Employee employee1 = new Employee(1, "John", 3000);
        Employee employee2 = new Employee(2, "Bob", 4000);
        employeeServiceIml.addEmployee(employee1);
        employeeServiceIml.addEmployee(employee2);
        Employee minSalaryEmployee = employeeServiceIml.getEmployeeWithMinSalary("Bob");
        assertEquals("John", minSalaryEmployee.getName());
    }

    @Test
    void testGetEmployeeWithMaxSalaryWhenEmpty() {
        List<Employee> emptyEmployees = new ArrayList<>();
        EmployeeServiceIml emptyEmployeeService = new EmployeeServiceIml();
        Employee employee = emptyEmployeeService.getEmployeeWithMaxSalary("John");
        assertNull(employee);
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee(1, "John", 5000);
        employeeServiceIml.addEmployee(employee);
        assertEquals(employeeServiceIml.getAllEmployeeInDepartment("John"), 1);
    }

    @Test
    public void testRemoveEmployee() {
        List<Employee> employees;
        Employee employee1 = new Employee(1, "John", 5000);
        employeeServiceIml.addEmployee(employee1);
        employeeServiceIml.removeEmployee(employee1);
        assertFalse(employeeServiceIml.getEmployee(employee1));

    }

    @Test
    public void testSearchEmployeeByName() {
        Employee employee1 = new Employee(2, "John", 3000);
        employeeServiceIml.addEmployee(employee1);
        Employee foundEmployee = employeeServiceIml.searchEmployeeByName("John");
        assertEquals(foundEmployee, employee1);
    }
    @Test
    void testGetAllEmployeeInDepartment() {
        Employee employee1 = new Employee(2, "John", 3000);
        employeeServiceIml.addEmployee(employee1);
        List<Employee> johnEmployee = employeeServiceIml.getAllEmployeeInDepartment("John");
        assertEquals(1, johnEmployee.size());
    }
}
