package ro.ubbcluj.cs.ams.chat.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChatMessageDTO {

    private String sender;
    private String receiver;
    private String content;
    private Integer conversationId;
}
