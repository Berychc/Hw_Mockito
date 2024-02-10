package com.example.mockitohw.demo.employeeController;

import com.example.mockitohw.demo.employee.Employee;
import com.example.mockitohw.demo.employeeService.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeesById(@PathVariable Integer id) {
        return employeeService.getAllEmployeeInDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public Integer getTotalSalary(@PathVariable String id) {
        return employeeService.getTotalSalary(id);
    }

}
