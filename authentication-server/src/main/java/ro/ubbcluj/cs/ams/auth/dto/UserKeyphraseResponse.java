package ro.ubbcluj.cs.ams.auth.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserKeyphraseResponse {

    private String username;
    private String message;
    private String keyphrase;
}