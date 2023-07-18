package course.jchw6.service;

import course.jchw6.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Map<String, Employee> getAll();
    Employee add(String firstName, String lastName, int department, int salary);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
}
