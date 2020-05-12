package ro.ubbcluj.cs.ams.attendance.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SubjectResponse {

    private Integer id;
    private String name;
    private Integer credits;
    private Integer year;
}
