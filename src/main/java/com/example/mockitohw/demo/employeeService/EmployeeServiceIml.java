package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceIml implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private EmployeeServiceIml employeeServiceIml;

    public EmployeeServiceIml() {
        this.employeeServiceIml = employeeServiceIml;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Integer getTotalSalary(String departmentName) {
        int totalSalary = 0;
        for (Employee employee : employees) {
            if (employee.getSalary().equals(departmentName)) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    @Override
    public List<Employee> getAllEmployeeInDepartment(Integer departmentName) {
        Stream<Employee> employeeStream = employeeServiceIml.getAllEmployees().stream();

        if (departmentName != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartmentId() == departmentName);
        }

        return employeeStream.collect(Collectors.toList());
    }


    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee searchEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public boolean getEmployee(Employee employee) {
        return employees.contains(employee);
    }
}
