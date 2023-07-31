package course.jchw6.service;

import course.jchw6.exception.*;
import course.jchw6.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;
    private final int maxCount;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
        maxCount = 3;
    }


    @Override
    public Map<String, Employee> getAll() {
        return employees;
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        checkFirstName(firstName);
        checkLastName(lastName);

        if (employees.size() == maxCount) {
            throw new EmployeeStorageIsFullException();
        }

        String key = getKeyString(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, department, salary);


        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = employees.remove(getKeyString(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = employees.get(getKeyString(firstName, lastName));
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public void checkFirstName(String firstName) {
        if (isNameBad(firstName)) {
            throw new BadEmployeeFirstName();
        }
    }

    public void checkLastName(String lastName) {
        if (isNameBad(lastName)) {
            throw new BadEmployeeLastName();
        }
    }

    private String getKeyString(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    private boolean isNameBad(String name) {
        return !StringUtils.isAlpha(name) || !StringUtils.isAllUpperCase(name.substring(0, 1)) || !StringUtils.isAllLowerCase(name.substring(1));
    }
}
