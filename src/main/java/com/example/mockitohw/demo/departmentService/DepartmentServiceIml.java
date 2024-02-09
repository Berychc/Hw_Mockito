package com.example.mockitohw.demo.departmentService;

import com.example.mockitohw.demo.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceIml implements DepartmentService {

    private final List<Employee> employees = new ArrayList<>();

    public DepartmentServiceIml() {
        employees.add(new Employee(1, "Egor", 5000));
        employees.add(new Employee(2, "Alex", 4500));
        employees.add(new Employee(3, "Harry", 6000));
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

}

