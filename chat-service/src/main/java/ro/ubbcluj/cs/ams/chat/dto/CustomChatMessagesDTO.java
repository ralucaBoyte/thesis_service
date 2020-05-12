package ro.ubbcluj.cs.ams.chat.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomChatMessagesDTO {
    private String sender;
    private String receiver;
    private String content;
}
