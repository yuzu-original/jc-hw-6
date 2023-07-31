package course.jchw6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Bad employee last name"
)
public class BadEmployeeLastName extends RuntimeException {
    public BadEmployeeLastName() {
    }

    public BadEmployeeLastName(String message) {
        super(message);
    }

    public BadEmployeeLastName(String message, Throwable cause) {
        super(message, cause);
    }

    public BadEmployeeLastName(Throwable cause) {
        super(cause);
    }

    public BadEmployeeLastName(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
