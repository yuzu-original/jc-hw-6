package course.jchw6.controller;

import course.jchw6.model.Employee;
import course.jchw6.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Map<String, Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/add")
    public Employee add(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam int department,
            @RequestParam int salary
            ) {
        return employeeService.add(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }
}
