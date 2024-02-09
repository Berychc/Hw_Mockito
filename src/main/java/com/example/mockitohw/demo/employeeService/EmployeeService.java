package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {


    Integer getTotalSalary(String departmentName);


    Employee getEmployeeWithMaxSalary(String departmentName);

    Employee getEmployeeWithMinSalary(String departmentName);

    List<Employee> getAllEmployeeInDepartment(String departmentName);
}
