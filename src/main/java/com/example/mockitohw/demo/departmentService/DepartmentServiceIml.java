package com.example.mockitohw.demo.departmentService;

import com.example.mockitohw.demo.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceIml implements DepartmentService {


    private final List<Employee> employees;
    private final DepartmentServiceIml departmentServiceIml = new DepartmentServiceIml();

    public DepartmentServiceIml() {
        employees = new ArrayList<>();
    }

    @PostConstruct
    private void postConstruct() {
        employees.add(new Employee(1, "Egor", 5000));
        employees.add(new Employee(2, "Alex", 4500));
        employees.add(new Employee(3, "Harry", 6000));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return departmentServiceIml.getAllEmployees().stream().
                filter(employee -> employee.getDepartmentId() == departmentId).
                max(Comparator.comparing(Employee::getSalary)).orElseThrow();
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return departmentServiceIml.getAllEmployees().stream().
                filter(employee -> employee.getDepartmentId() == departmentId).
                min(Comparator.comparing(Employee::getSalary)).orElseThrow();
    }

    @Override
    public Map<Integer, List<Employee>> getGroupEmployeesByDepartment() {
        return departmentServiceIml.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

}

