package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee add(Integer departmentId, String name, Integer salary);

    Employee remove(String name);

    Employee find(String name);

    Collection<Employee> findAll();
}
