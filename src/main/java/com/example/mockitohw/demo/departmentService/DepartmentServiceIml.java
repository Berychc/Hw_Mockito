package com.example.mockitohw.demo.departmentService;

import com.example.mockitohw.demo.employee.Employee;
import com.example.mockitohw.demo.employeeService.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceIml implements DepartmentService {

    private final EmployeeService employeeService;
    public DepartmentServiceIml(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostConstruct
    private void postConstruct() {
        Employee employee1 = new Employee(1, "Egor", 5000);
        Employee employee2 = new Employee(2, "Alex", 4500);
        Employee employee3 = new Employee(3, "Harry", 6000);
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.findAll().stream().
                filter(employee -> employee.getDepartmentId() == departmentId).
                max(Comparator.comparing(Employee::getSalary)).orElseThrow();
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.findAll().stream().
                filter(employee -> employee.getDepartmentId() == departmentId).
                min(Comparator.comparingInt(Employee::getSalary)).orElseThrow();
    }

    @Override
    public Collection<Employee> findEmployeesByDepartment(Integer departmentId) {
        Stream<Employee> employeeStream = employeeService.findAll().stream();

        if (departmentId != null) {
            employeeStream = employeeStream.filter(employee -> employee.getDepartmentId() == departmentId);
        }
        return employeeStream.collect(Collectors.toList());
    }
    @Override
    public Map<Integer, List<Employee>> getGroupEmployeesByDepartment() {
        return employeeService.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

}

