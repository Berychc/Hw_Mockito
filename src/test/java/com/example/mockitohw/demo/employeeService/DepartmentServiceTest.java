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
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;


    @InjectMocks
    private DepartmentService departmentService;

    public DepartmentServiceTest(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    private List<Employee> employees = List.of(
            new Employee(1,"John" , 3000),
            new Employee(2,"Soup" , 4000),
            new Employee(3,"Ghost" , 5000));

    @Test
    public void testGetGroupEmployeesByDepartment() {
        Employee employee1 = employeeService.add(DEPARTMENT_ID,FIRST_NAME,SALARY) ;
        Employee employee2 = employeeService.add(DEPARTMENT_ID,FIRST_NAME1,SALARY) ;


        List<Employee> allEmployees = new ArrayList<>();
        allEmployees.add(employee1);
        allEmployees.add(employee2);

        when(employeeService.findAll()).thenReturn(allEmployees);


        Map<Integer, List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(1, Collections.singletonList(employee1));
        expectedMap.put(2, Collections.singletonList(employee2));

        Map<Integer, List<Employee>> actualMap = departmentService.getGroupEmployeesByDepartment();
        assertEquals(expectedMap, actualMap);
    }
    @Test
    void testGetMaxSalary() {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(employees.get(1),departmentService.getEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    void testGetMinSalary() {
        when(employeeService.findAll()).thenReturn(employees);
        assertEquals(employees.get(0),departmentService.getEmployeeWithMinSalary(DEPARTMENT_ID));
    }
}
