package com.example.mockitohw.demo.departmentService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<Employee> getAllEmployees();

    Employee getEmployeeWithMaxSalary(Integer departmentId);


    Employee getEmployeeWithMinSalary(Integer departmentId);

    Map<Integer, List<Employee>> getGroupEmployeesByDepartment();

    void addEmployee(Employee employee);
}