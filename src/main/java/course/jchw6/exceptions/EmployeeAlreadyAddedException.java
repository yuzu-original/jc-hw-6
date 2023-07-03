package course.jchw6.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        code = HttpStatus.CONFLICT,
        reason = "Employee already added"
)
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
    }
}
