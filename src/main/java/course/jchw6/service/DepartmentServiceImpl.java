package course.jchw6.service;

import course.jchw6.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public int getMinSalary(int department) {
        return employeeService.getAll().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .min()
                .orElse(0);
    }

    @Override
    public int getMaxSalary(int department) {
        return employeeService.getAll().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .max()
                .orElse(0);
    }

    @Override
    public int getTotalSalary(int department) {
        return employeeService.getAll().values().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Map<Integer, List<Employee>> getEmployees() {
        return employeeService.getAll().values().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        HashMap::new,
                        Collectors.toList()
                ));
    }

    @Override
    public List<Employee> getEmployees(int department) {
        return employeeService.getAll().values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
}
