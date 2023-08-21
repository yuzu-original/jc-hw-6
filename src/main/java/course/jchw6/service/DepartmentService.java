package course.jchw6.service;

import course.jchw6.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    int getMinSalary(int department);
    int getMaxSalary(int department);
    int getTotalSalary(int department);
    Map<Integer, List<Employee>> getEmployees();
    List<Employee> getEmployees(int department);
}
