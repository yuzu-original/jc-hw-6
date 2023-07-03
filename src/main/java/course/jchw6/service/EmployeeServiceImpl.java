package course.jchw6.service;

import course.jchw6.exception.EmployeeAlreadyAddedException;
import course.jchw6.exception.EmployeeNotFoundException;
import course.jchw6.exception.EmployeeStorageIsFullException;
import course.jchw6.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;
    private final int maxCount;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
        maxCount = 3;
    }


    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() == maxCount) {
            throw new EmployeeStorageIsFullException();
        }

        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
}
