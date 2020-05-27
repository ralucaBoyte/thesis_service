package ro.ubbcluj.cs.ams.attendance.dto;


import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AttendanceResponse {

    private Integer id;
    private String student_id; //TODO : numele cursului
    private String name;
    private String type;
    private Integer week;
    //private Timestamp created_at; //TODO : numele activity
}
