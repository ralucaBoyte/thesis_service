package ro.ubbcluj.cs.ams.auth.service.exception;

public enum AuthExceptionType {
    INVALID_CREDENTIALS,
    OK,
    PREVIOUSLY_LOGGED_FROM_ANOTHER_DEVICE,
    LOGIN_ONLY_FROM_MOBILE_DEVICE_FOR_STUDENT,
    LOGIN_NOT_ALLOWED_FROM_COLLEAGUES_DEVICE
}
