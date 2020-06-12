package ro.ubbcluj.cs.ams.auth.service.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AuthenticationException extends RuntimeException {

    private AuthExceptionType type;
    private HttpStatus httpStatus;
    private String message;

    public AuthenticationException(String message, AuthExceptionType type, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.type = type;
        this.httpStatus = httpStatus;
    }

    public AuthenticationException(String message, Throwable cause, AuthExceptionType type, HttpStatus httpStatus) {
        super(message, cause);
        this.type = type;
        this.httpStatus = httpStatus;
    }
}
