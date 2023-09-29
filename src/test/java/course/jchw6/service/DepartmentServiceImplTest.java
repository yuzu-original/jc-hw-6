package course.jchw6.service;

import course.jchw6.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.stream.Stream;

import static course.jchw6.constant.EmployeeConstants.*;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeServiceMock;
    @InjectMocks
    private DepartmentServiceImpl out;

    @ParameterizedTest
    @MethodSource("provideParamsForGetMinSalary")
    public void getMinSalary_departmentExists_shouldReturnMinSalary(int department, int expected) {
        when(employeeServiceMock.getAll())
                .thenReturn(EMPLOYEE_BY_NAME);

        assertEquals(expected, out.getMinSalary(department));
    }

    @Test
    public void getMinSalary_departmentDoesNotExist_shouldReturnZero() {
        when(employeeServiceMock.getAll())
                .thenReturn(EMPLOYEE_BY_NAME);

        assertEquals(0, out.getMinSalary(999));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForGetMaxSalary")
    public void getMaxSalary_departmentExists_shouldReturnMaxSalary(int department, int expected) {
        when(employeeServiceMock.getAll())
                .thenReturn(EMPLOYEE_BY_NAME);

        assertEquals(expected, out.getMaxSalary(department));
    }

    @Test
    public void getMaxSalary_departmentDoesNotExist_shouldReturnZero() {
        when(employeeServiceMock.getAll())
                .thenReturn(EMPLOYEE_BY_NAME);

        assertEquals(0, out.getMaxSalary(999));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForGetTotalSalary")
    public void getTotalSalary_departmentExists_shouldReturnTotalSalary(int department, int expected) {
        when(employeeServiceMock.getAll())
                .thenReturn(EMPLOYEE_BY_NAME);

        assertEquals(expected, out.getTotalSalary(department));
    }

    @Test
    public void getTotalSalary_departmentDoesNotExist_shouldReturnZero() {
        when(employeeServiceMock.getAll())
                .thenReturn(EMPLOYEE_BY_NAME);

        assertEquals(0, out.getTotalSalary(999));
    }

    @Test
    public void getEmployees_employeesExist_shouldReturnEmployeesGroupedByDepartment() {
        when(employeeServiceMock.getAll())
                .thenReturn(EMPLOYEE_BY_NAME);

        assertEquals(EMPLOYEES_BY_DEPARTMENT, out.getEmployees());
    }

    @Test
    public void getEmployees_employeesDoNotExist_shouldReturnEmptyMap() {
        when(employeeServiceMock.getAll())
                .thenReturn(emptyMap());

        assertEquals(emptyMap(), out.getEmployees());
    }

    @ParameterizedTest
    @MethodSource("provideParamsForGetEmployeesByDepartment")
    public void getEmployees_byDepartmentAndDepartmentExists_shouldReturnEmployeesList(int department, List<Employee> expected) {
        when(employeeServiceMock.getAll())
                .thenReturn(EMPLOYEE_BY_NAME);

        assertEquals(expected, out.getEmployees(department));
    }

    @Test
    public void getEmployees_byDepartmentAndDepartmentDoesNotExist_shouldReturnEmptyList() {
        when(employeeServiceMock.getAll())
                .thenReturn(EMPLOYEE_BY_NAME);

        assertEquals(emptyList(), out.getEmployees(999));
    }

    private static Stream<Arguments> provideParamsForGetMinSalary() {
        return MIN_SALARY_BY_DEPARTMENT.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }

    private static Stream<Arguments> provideParamsForGetMaxSalary() {
        return MAX_SALARY_BY_DEPARTMENT.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }

    private static Stream<Arguments> provideParamsForGetTotalSalary() {
        return TOTAL_SALARY_BY_DEPARTMENT.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }

    private static Stream<Arguments> provideParamsForGetEmployeesByDepartment() {
        return EMPLOYEES_BY_DEPARTMENT.entrySet().stream()
                .map(entry -> Arguments.of(entry.getKey(), entry.getValue()));
    }
}
