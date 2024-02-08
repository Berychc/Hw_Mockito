package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {


    List<Employee> getAllEmployeeInDepartment(String departmentName);

    Integer getTotalSalary(String departmentName);

    Employee getEmployeeWithMaxSalary(String departmentName);

    Employee getEmployeeWithMinSalary(String departmentName);

    Map<Integer, List<Employee>> getGroupEmployeesByDepartment();
}
