package ro.ubbcluj.cs.ams.chat.service.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ChatServiceException extends RuntimeException {

    private ChatException type;
    private HttpStatus status;

    public ChatServiceException(String msg, ChatException type, HttpStatus status) {

        super(msg);
        this.type = type;
        this.status = status;
    }
}