package com.example.mockitohw.demo.departmentConroller;

import com.example.mockitohw.demo.departmentService.DepartmentService;
import com.example.mockitohw.demo.employee.Employee;
import com.example.mockitohw.demo.employeeService.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/{id}/salary/max")
    public Employee getMaxSalary(@PathVariable Integer id) {
        return departmentService.getEmployeeWithMaxSalary(id);
    }

    @GetMapping("/{id}/salary/min")
    public Employee getMinSalary(@PathVariable Integer id) {
        return departmentService.getEmployeeWithMinSalary(id);
    }

    @GetMapping("/all")
    public Collection<Employee> findEmployees(@RequestParam int departmentId) {
        return departmentService.findEmployeesByDepartment(departmentId);
    }

    @GetMapping("/allGroup")
    public Map<Integer, List<Employee>> findGroupEmployees() {
        return departmentService.getGroupEmployeesByDepartment();
    }


}
