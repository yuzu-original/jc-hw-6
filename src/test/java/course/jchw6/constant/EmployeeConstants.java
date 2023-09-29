package course.jchw6.constant;

import course.jchw6.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeConstants {
    public static final Employee EMPLOYEE_1 = new Employee("Yu", "Zu", 1, 10_000);
    public static final Employee EMPLOYEE_2 = new Employee("Ar", "Ra", 1, 20_000);
    public static final Employee EMPLOYEE_3 = new Employee("Anna", "C", 1, 30_000);
    public static final Employee EMPLOYEE_4 = new Employee("No", "Name", 2, 40_000);
    public static final Employee EMPLOYEE_5 = new Employee("Best", "User", 2, 50_000);
    public static final Employee EMPLOYEE_6 = new Employee("Random", "Name", 3, 60_000);
    public static final Map<String, Employee> EMPLOYEE_BY_NAME = new HashMap<>(
            Map.of(
                    "Yu Zu", EMPLOYEE_1,
                    "Ar Ra", EMPLOYEE_2,
                    "Anna C", EMPLOYEE_3,
                    "No Name", EMPLOYEE_4,
                    "Best User", EMPLOYEE_5,
                    "Random Name", EMPLOYEE_6
            )
    );
    public static final List<Employee> DEPARTMENT_1_EMPLOYEES = new ArrayList<>(List.of(EMPLOYEE_1, EMPLOYEE_2, EMPLOYEE_3));
    public static final List<Employee> DEPARTMENT_2_EMPLOYEES = new ArrayList<>(List.of(EMPLOYEE_5, EMPLOYEE_4));
    public static final List<Employee> DEPARTMENT_3_EMPLOYEES = new ArrayList<>(List.of(EMPLOYEE_6));
    public static final Map<Integer, List<Employee>> EMPLOYEES_BY_DEPARTMENT = new HashMap<>(
            Map.of(
                    1, DEPARTMENT_1_EMPLOYEES,
                    2, DEPARTMENT_2_EMPLOYEES,
                    3, DEPARTMENT_3_EMPLOYEES
            )
    );
    public static final Map<Integer, Integer> TOTAL_SALARY_BY_DEPARTMENT = new HashMap<>(
            Map.of(
                    1, 60_000,
                    2, 90_000,
                    3, 60_000
            )
    );

    public static final Map<Integer, Integer> MAX_SALARY_BY_DEPARTMENT = new HashMap<>(
            Map.of(
                    1, 30_000,
                    2, 50_000,
                    3, 60_000
            )
    );
    public static final Map<Integer, Integer> MIN_SALARY_BY_DEPARTMENT = new HashMap<>(
            Map.of(
                    1, 10_000,
                    2, 40_000,
                    3, 60_000
            )
    );
}
