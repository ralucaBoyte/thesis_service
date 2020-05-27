package ro.ubbcluj.cs.ams.attendance.dto;


import lombok.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AttendanceRequestForView {

    @NotNull
    private Integer course_id;
    @NotNull
    private Integer activity_id;
    @NotNull
    private Integer week;
}
