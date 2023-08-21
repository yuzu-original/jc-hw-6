package course.jchw6.controller;

import course.jchw6.model.Employee;
import course.jchw6.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable int id) {
        return departmentService.getEmployees(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getTotalSalaryByDepartment(@PathVariable int id) {
        return departmentService.getTotalSalary(id);
    }

    @GetMapping("/{id}/salary/max")
    public int getMaxSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMaxSalary(id);
    }

    @GetMapping("/{id}/salary/min")
    public int getMinSalaryByDepartment(@PathVariable int id) {
        return departmentService.getMinSalary(id);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getEmployees() {
        return departmentService.getEmployees();
    }
}
