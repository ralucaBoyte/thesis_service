package ro.ubbcluj.cs.ams.auth.service.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    //private HttpStatus errorCode;
    private String message;
    private AuthExceptionType authExceptionType;

//    public HttpStatus getHttpStatus() {
//        return errorCode;
//    }
//    public void setErrorCode(HttpStatus errorCode) {
//        this.errorCode = errorCode;
//    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public AuthExceptionType getAuthExceptionType() {
        return authExceptionType;
    }

    public void setAuthExceptionType(AuthExceptionType authExceptionType) {
        this.authExceptionType = authExceptionType;
    }
}
