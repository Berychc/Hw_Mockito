package com.example.mockitohw.demo.employeeService;


import com.example.mockitohw.demo.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceIml implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeServiceIml() {
        employees.add(new Employee(1, "Egor", 5000));
        employees.add(new Employee(2, "Alex", 4500));
        employees.add(new Employee(3, "Harry", 6000));
    }

    @Override
    public List<Employee> getAllEmployeeInDepartment(String departmentName) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getEmployees().equals(departmentName)) {
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public Integer getTotalSalary(String departmentName) {
        int totalSalary = 0;
        for (Employee employee : employees) {
            if (employee.getEmployees().equals(departmentName)) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(String departmentName) {
        if (employees.isEmpty()) {
            return null;
        }
        Employee maxSalaryEmployee = null;
        int maxSalary = 0;
        for (Employee employee : employees) {
            if (employee.getEmployees().equals(departmentName) && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    @Override
    public Employee getEmployeeWithMinSalary(String departmentName) {
        if (employees.isEmpty()) {
            return null;
        }
        Employee minSalaryEmployee = null;
        int minSalary = 0;
        for (Employee employee : employees) {
            if (employee.getEmployees().equals(departmentName) && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    @Override
    public Map<Integer, List<Employee>> getGroupEmployeesByDepartment() {
        Map<Integer, List<Employee>> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            int departNumber = employee.getId();
            if (!employeeMap.containsKey(departNumber)) {
                employeeMap.put(departNumber, new ArrayList<>());
            }
            employeeMap.get(departNumber).add(employee);
        }
        return employeeMap;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee searchEmployeeByName(String name) {
        for (Employee employee : employees) {
            if (employee.getEmployees().equals(name)) {
                return employee;
            }
        }
        return null;
    }
}
