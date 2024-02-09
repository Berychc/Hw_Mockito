package com.example.mockitohw.demo.departmentService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> getGroupEmployeesByDepartment();

}