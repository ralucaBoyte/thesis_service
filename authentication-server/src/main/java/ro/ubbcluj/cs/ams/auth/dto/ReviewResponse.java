package ro.ubbcluj.cs.ams.auth.dto;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReviewResponse {

    private String student;
    private String feedback;
    private Float reviewGrade;
}
