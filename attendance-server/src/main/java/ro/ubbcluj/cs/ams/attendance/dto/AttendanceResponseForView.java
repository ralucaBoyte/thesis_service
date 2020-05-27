package ro.ubbcluj.cs.ams.attendance.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AttendanceResponseForView {

    private String student_id;
    private String name;
    private String type;
}
