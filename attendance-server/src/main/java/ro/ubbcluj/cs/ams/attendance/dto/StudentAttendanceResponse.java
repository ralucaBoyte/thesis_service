package ro.ubbcluj.cs.ams.attendance.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StudentAttendanceResponse {
    private String course; //TODO : numele cursului
    private String activity; //TODO : numele activity
}
