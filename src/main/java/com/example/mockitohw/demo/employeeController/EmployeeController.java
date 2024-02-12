package com.example.mockitohw.demo.employeeController;

import com.example.mockitohw.demo.employee.Employee;
import com.example.mockitohw.demo.employeeService.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam Integer departmentId, @RequestParam String name, @RequestParam Integer salary) {
        Employee result = employeeService.add(departmentId, name, salary);
        return generateMessage(result, "Сотрдуник создан");

    }
    @GetMapping("/remove")
    public String remove(@RequestParam String name) {
        Employee result = employeeService.remove(name);
        return generateMessage(result, "Сотрудник удален");
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String name) {
        return employeeService.find(name);
    }
    @GetMapping
    private Collection<Employee> findAll() {
        return employeeService.findAll();
    }

    private String generateMessage(Employee employee, String text) {
        return String.format("Сотрудник %s %s %s.",
                employee.getName(), text);
    }
}
