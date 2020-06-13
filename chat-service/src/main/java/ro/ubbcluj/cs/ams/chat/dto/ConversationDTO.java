package ro.ubbcluj.cs.ams.chat.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ConversationDTO {
    private String sender;
    private String receiver;

}
