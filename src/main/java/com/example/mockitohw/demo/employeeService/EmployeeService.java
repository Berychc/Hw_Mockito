package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> getAllEmployee(String departamentName);

    double getTotalSalary();

    Integer getMaxSalary();

    Integer getMinSalary();

    Map<Integer, List<Employee>> getGroupEmployeesByDepartment();
}
