package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceIml implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

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
    public Employee getEmployeeWithMaxSalary(String departmentName) {
        if (employees.isEmpty()) {
            return null;
        }
        Employee maxSalaryEmployee = null;
        int maxSalary = 0;
        for (Employee employee : employees) {
            if (employee.getName().equals(departmentName) && employee.getSalary() > maxSalary) {
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
            if (employee.getName().equals(departmentName) && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }
    @Override
    public List<Employee> getAllEmployeeInDepartment(String departmentName) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(departmentName)) {
                result.add(employee);
            }
        }
        return result;
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
