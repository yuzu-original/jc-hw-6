package course.jchw6.services;

import course.jchw6.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
}
