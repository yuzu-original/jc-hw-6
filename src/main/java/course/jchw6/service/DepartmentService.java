package course.jchw6.service;

import course.jchw6.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getEmployeeWithMinSalary(int department);
    Employee getEmployeeWithMaxSalary(int department);
    Map<Integer, List<Employee>> getEmployees();
    List<Employee> getEmployees(int department);
}
