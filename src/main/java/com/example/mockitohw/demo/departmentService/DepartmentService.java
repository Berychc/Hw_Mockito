package com.example.mockitohw.demo.departmentService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {


    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Employee getEmployeeWithMinSalary(Integer departmentId);

    Collection<Employee> findEmployeesByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> getGroupEmployeesByDepartment();
}