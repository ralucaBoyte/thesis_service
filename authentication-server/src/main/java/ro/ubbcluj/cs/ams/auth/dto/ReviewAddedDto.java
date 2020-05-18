package ro.ubbcluj.cs.ams.auth.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReviewAddedDto {

    private String professor;
    private String feedback;
    private Float reviewGrade;
}
