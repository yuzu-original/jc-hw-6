package course.jchw6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Bad employee first name"
)
public class BadEmployeeFirstName extends RuntimeException {
    public BadEmployeeFirstName() {
    }

    public BadEmployeeFirstName(String message) {
        super(message);
    }

    public BadEmployeeFirstName(String message, Throwable cause) {
        super(message, cause);
    }

    public BadEmployeeFirstName(Throwable cause) {
        super(cause);
    }

    public BadEmployeeFirstName(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
