package ro.ubbcluj.cs.ams.auth.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private String keyphrase;

    private String message;
}
