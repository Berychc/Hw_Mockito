package com.example.mockitohw.demo.employeeService;


import com.example.mockitohw.demo.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceIml implements EmployeeService {

    private final List<Employee> employees;

    public EmployeeServiceIml(List<Employee> employees) {
        this.employees = employees;
    }

}
