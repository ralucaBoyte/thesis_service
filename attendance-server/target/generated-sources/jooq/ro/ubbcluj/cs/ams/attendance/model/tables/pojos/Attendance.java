/*
 * This file is generated by jOOQ.
 */
package ro.ubbcluj.cs.ams.attendance.model.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1294090094;

    private Integer       id;
    private String        studentId;
    private LocalDateTime createdAt;
    private Integer       attendanceInfoId;

    public Attendance() {}

    public Attendance(Attendance value) {
        this.id = value.id;
        this.studentId = value.studentId;
        this.createdAt = value.createdAt;
        this.attendanceInfoId = value.attendanceInfoId;
    }

    public Attendance(
        Integer       id,
        String        studentId,
        LocalDateTime createdAt,
        Integer       attendanceInfoId
    ) {
        this.id = id;
        this.studentId = studentId;
        this.createdAt = createdAt;
        this.attendanceInfoId = attendanceInfoId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getAttendanceInfoId() {
        return this.attendanceInfoId;
    }

    public void setAttendanceInfoId(Integer attendanceInfoId) {
        this.attendanceInfoId = attendanceInfoId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Attendance (");

        sb.append(id);
        sb.append(", ").append(studentId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(attendanceInfoId);

        sb.append(")");
        return sb.toString();
    }
}
