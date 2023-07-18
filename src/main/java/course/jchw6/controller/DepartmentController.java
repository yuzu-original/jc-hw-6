package course.jchw6.controller;

import course.jchw6.model.Employee;
import course.jchw6.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAll() {
        return departmentService.getEmployees();
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public List<Employee> getAllByDepartment(@RequestParam("departmentId") int department) {
        return departmentService.getEmployees(department);
    }

    @GetMapping(value = "/max-salary", params = {"departmentId"})
    public Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeWithMaxSalary(department);
    }

    @GetMapping(value = "/min-salary", params = {"departmentId"})
    public Employee getEmployeeWithMinSalary(@RequestParam("departmentId") int department) {
        return departmentService.getEmployeeWithMinSalary(department);
    }
}
