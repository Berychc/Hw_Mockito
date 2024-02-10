package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.departmentService.DepartmentService;
import com.example.mockitohw.demo.employee.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {

    @InjectMocks
    private final DepartmentService departmentService;

    @Mock
    private final EmployeeServiceIml employeeServiceIml = new EmployeeServiceIml();

    public DepartmentServiceTest(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Test
    public void testGetGroupEmployeesByDepartment() {
        Employee employee1 = new Employee(1, "John", 5000);
        Employee employee2 = new Employee(2, "Bob", 6000);

        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.add(employee1);
        allEmployees.add(employee2);

        when(employeeServiceIml.getAllEmployees()).thenReturn(allEmployees);


        Map<Integer, List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(1, Collections.singletonList(employee1));
        expectedMap.put(2, Collections.singletonList(employee2));

        Map<Integer, List<Employee>> actualMap = departmentService.getGroupEmployeesByDepartment();
        assertEquals(expectedMap, actualMap);
    }
    @Test
    void testGetMaxSalary() {
        Employee employee1 = new Employee(1, "John", 3000);
        Employee employee2 = new Employee(2, "Bob", 4000);
        departmentService.addEmployee(employee1);
        departmentService.addEmployee(employee2);
        Employee maxSalaryEmployee = departmentService.getEmployeeWithMaxSalary(2);
        assertEquals("Bob", maxSalaryEmployee.getName());
    }

    @Test
    void testGetMinSalary() {
        Employee employee1 = new Employee(1, "John", 3000);
        Employee employee2 = new Employee(2, "Bob", 4000);
        departmentService.addEmployee(employee1);
        departmentService.addEmployee(employee2);
        Employee maxSalaryEmployee = departmentService.getEmployeeWithMinSalary(1);
        assertEquals("John", maxSalaryEmployee.getName());
    }
}
