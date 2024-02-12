package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceIml implements EmployeeService {

    private final Map<String, Employee> employees;
    public EmployeeServiceIml() {
        employees = new HashMap<>();
    }

    private void validateNames(String... names) {
        for (String name : names) {
            if (!isAlpha(name)) {
                throw new RuntimeException(name);
            }
        }
    }

    public static boolean isAlpha(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Employee add(Integer departmentId, String name, Integer salary) {
        validateNames(name);
        Employee employeeNew = new Employee(departmentId, name, salary);
        if (!employees.containsKey(name)) {
            throw new RuntimeException("Сотрудник существует");
        }
        return employees.get(name);
    }

    @Override
    public Employee remove(String name) {
        validateNames(name);
        if (!employees.containsKey(name)) {
            throw new RuntimeException("Сотрудник не найден");
        }
        return employees.remove(name);
    }

    @Override
    public Employee find(String name) {
        validateNames(name);
        if (!employees.containsKey(name)) {
            throw new RuntimeException("Сотрудник не найден");
        }
        return employees.get(name);
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

}
