package course.jchw6.service;

import course.jchw6.exception.*;
import course.jchw6.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    private EmployeeServiceImpl out;

    @BeforeEach
    public void setUp() {
        out = new EmployeeServiceImpl();
    }

    @Test
    public void add_employeeDoesNotExist_shouldAddEmployeeAndReturnIt() {
        Employee actual = out.add("Yu", "Zu", 1, 100);
        Employee expected = new Employee("Yu", "Zu", 1, 100);
        assertEquals(expected, actual);
        assertEquals(Map.of("Yu Zu", expected), out.getAll());
    }

    @Test
    public void add_employeeExists_shouldThrowEmployeeAlreadyAddedException() {
        Employee first = out.add("Yu", "Zu", 1, 100);
        assertThrows(EmployeeAlreadyAddedException.class, () -> out.add("Yu", "Zu", 2, 200));
        assertEquals(Map.of("Yu Zu", first), out.getAll());
    }

    @Test
    public void add_exceededLimit_shouldThrowEmployeeStorageIsFullException() {
        int limit = out.getMaxCount();
        for (int i = 0; i < limit; i++) {
            out.add("Yu", "Zu" + "u".repeat(i), 1, 100);
        }
        assertThrows(EmployeeStorageIsFullException.class, () -> out.add("New", "User", 1, 100));
        assertFalse(out.getAll().containsKey("New User"));

    }

    @Test
    public void remove_employeeExists_shouldRemoveEmployeeAndReturnIt() {
        Employee first = out.add("A", "A", 1, 100);
        Employee second = out.add("B", "B", 1, 100);
        Employee actual = out.remove("B", "B");
        assertEquals(second, actual);
        assertEquals(Map.of("A A", first), out.getAll());
    }

    @Test
    public void remove_employeeDoesNotExist_shouldThrowEmployeeNotFoundException() {
        Employee first = out.add("A", "A", 1, 100);
        Employee second = out.add("B", "B", 1, 100);
        assertThrows(EmployeeNotFoundException.class, () -> out.remove("B", "User"));
        assertEquals(Map.of("A A", first, "B B", second), out.getAll());
    }

    @Test
    public void find_employeeExists_shouldReturnEmployee() {
        out.add("A", "A", 1, 100);
        Employee second = out.add("B", "B", 1, 100);
        Employee actual = out.find("B", "B");
        assertEquals(second, actual);
    }

    @Test
    public void find_employeeDoesNotExist_shouldThrowEmployeeNotFoundException() {
        out.add("A", "A", 1, 100);
        out.add("B", "B", 1, 100);
        assertThrows(EmployeeNotFoundException.class, () -> out.find("B", "Bad"));
    }

    @ParameterizedTest
    @MethodSource("provideGoodParamsForCheckFirstOrLastName")
    public void checkFirstName_goodFirstName_shouldNotThrow(String firstName) {
        assertDoesNotThrow(() -> out.checkFirstName(firstName));
    }

    @ParameterizedTest
    @MethodSource("provideBadParamsForCheckFirstOrLastName")
    public void checkFirstName_badFirstName_shouldThrowBadEmployeeFirstName(String firstName) {
        assertThrows(BadEmployeeFirstName.class, () -> out.checkFirstName(firstName));
    }

    @ParameterizedTest
    @MethodSource("provideGoodParamsForCheckFirstOrLastName")
    public void checkLastName_goodLastName_shouldNotThrow(String firstName) {
        assertDoesNotThrow(() -> out.checkLastName(firstName));
    }

    @ParameterizedTest
    @MethodSource("provideBadParamsForCheckFirstOrLastName")
    public void checkLastName_badLastName_shouldThrowBadEmployeeLastName(String lastName) {
        assertThrows(BadEmployeeLastName.class, () -> out.checkLastName(lastName));
    }

    private static Stream<String> provideGoodParamsForCheckFirstOrLastName() {
        return Stream.of(
                "Yu",
                "Zuuuuuuuuuuuuuuu",
                "A",
                "CoOl",
                "fOnT",
                "BIG",
                "small",
                "латиница"
        );
    }

    private static Stream<String> provideBadParamsForCheckFirstOrLastName() {
        return Stream.of(
                "I hate space",
                ">:D",
                "      very",
                "   very   ",
                "sad       ",
                "new\nline",
                "a-b",
                "a_b",
                "",
                " ",
                "1",
                "SuperPro2007",
                "krut0y",
                "1first"
        );
    }
}
