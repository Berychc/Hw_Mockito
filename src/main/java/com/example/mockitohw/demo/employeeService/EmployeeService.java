package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Integer getTotalSalary(String departmentName);


    List<Employee> getAllEmployeeInDepartment(Integer departmentName);
}
