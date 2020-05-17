package ro.ubbcluj.cs.ams.auth.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReviewRequest {

    @NotNull
    private String professor;
}
