package ro.ubbcluj.cs.ams.attendance.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ActivityResponse {

    private Integer id;
    private String type;
}
