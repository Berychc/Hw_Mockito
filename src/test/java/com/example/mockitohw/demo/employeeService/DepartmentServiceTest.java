package com.example.mockitohw.demo.employeeService;

import com.example.mockitohw.demo.departmentService.DepartmentService;
import com.example.mockitohw.demo.employee.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static com.example.mockitohw.demo.employeeService.EmployeeTestConstant.EmployeeTestConstants.*;
import static junit.framework.TestCase.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeServiceIml employeeServiceIml;


    @InjectMocks
    private DepartmentService departmentService;

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

        when(employeeServiceIml.findAll()).thenReturn(allEmployees);


        Map<Integer, List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(1, Collections.singletonList(employee1));
        expectedMap.put(2, Collections.singletonList(employee2));

        Map<Integer, List<Employee>> actualMap = departmentService.getGroupEmployeesByDepartment();
        assertEquals(expectedMap, actualMap);
    }
    @Test
    void testGetMaxSalary() {
        when(employeeServiceIml.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE,departmentService.getEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    void testGetMinSalary() {
        when(employeeServiceIml.findAll()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE,departmentService.getEmployeeWithMinSalary(DEPARTMENT_ID));
    }
}
