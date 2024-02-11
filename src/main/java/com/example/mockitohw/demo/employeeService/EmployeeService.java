package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Integer getTotalSalary(String departmentName);


    List<Employee> getAllEmployeeInDepartment(Integer departmentName);

    Collection<Employee> findAll();
}
