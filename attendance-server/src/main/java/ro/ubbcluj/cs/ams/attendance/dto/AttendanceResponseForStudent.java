package ro.ubbcluj.cs.ams.attendance.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class AttendanceResponseForStudent {
    private String student_id;
    private String name;
    private String type;
    private int week;
}
