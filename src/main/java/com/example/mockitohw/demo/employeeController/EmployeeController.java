package com.example.mockitohw.demo.employeeController;

import com.example.mockitohw.demo.employee.Employee;
import com.example.mockitohw.demo.employeeService.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/{id}")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/salary/sum")
    public Integer getTotalSalary(@PathVariable String id) {
        return employeeService.getTotalSalary(id);
    }

    @GetMapping("/salary/max")
    public Employee getMaxSalary(@PathVariable String id) {
        return employeeService.getEmployeeWithMaxSalary(id);
    }

    @GetMapping("/salary/min")
    public Employee getMinSalary(@PathVariable String id) {
        return employeeService.getEmployeeWithMinSalary(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployeesById(@PathVariable String id) {
        return employeeService.getAllEmployeeInDepartment(id);
    }
}
