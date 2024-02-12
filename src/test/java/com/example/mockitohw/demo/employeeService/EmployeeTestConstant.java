package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.employee.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeTestConstant {
    public static class EmployeeTestConstants {
        public static final String FIRST_NAME = "John";
        public static final String FIRST_NAME1 = "Soup";
        public static final int SALARY = 3000;
        public static final int MIN_SALARY = 1000;
        public static final int DEPARTMENT_ID = 1;
        public static final int DEPARTMENT_ID1 = 2;
        public static final Employee MAX_SALARY_EMPLOYEE = new Employee(DEPARTMENT_ID, FIRST_NAME, SALARY);
        public static final Employee MIN_SALARY_EMPLOYEE = new Employee( DEPARTMENT_ID, FIRST_NAME, MIN_SALARY);
        public static final List<Employee> EMPLOYEES = List.of(MIN_SALARY_EMPLOYEE, MAX_SALARY_EMPLOYEE);
        public static final Employee DIFFRENT_DEPARTMENT_EMPLOYEE = new Employee(DEPARTMENT_ID, FIRST_NAME, SALARY);
        public static final Set<Employee> DIFFRENT_DEPARTMENT_EMPLOYEES = Set.of(MIN_SALARY_EMPLOYEE, DIFFRENT_DEPARTMENT_EMPLOYEE);
        public static final Map<Integer, List<Employee>> DEPARTMENT_MAP =
                DIFFRENT_DEPARTMENT_EMPLOYEES.stream().collect(groupingBy(Employee::getDepartmentId));
    }
}
