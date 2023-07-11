package course.jchw6.service;

import course.jchw6.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
}
