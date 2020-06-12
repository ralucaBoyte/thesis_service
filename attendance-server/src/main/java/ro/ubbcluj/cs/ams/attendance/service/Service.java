package ro.ubbcluj.cs.ams.attendance.service;

import ro.ubbcluj.cs.ams.attendance.dto.*;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceRecord;

import java.util.List;

public interface Service {

    AttendanceInfoResponse addAttendanceInfo(AttendanceInfoReq attendanceInfoReq, String username);

    StudentAttendanceResponse addAttendance(AttendanceRequest attendanceRequest, String username);

    List<AttendanceResponse> getAllAttendances();
    List<AttendanceResponseForView> getAllAttendancesForCourseAndWeek(Integer course_id, Integer activity_id, Integer week);
    List<AttendanceResponseForStudent> getAllAttendancesForStudent(String student);

    List<SubjectResponse> findAllSubjects();
    List<ActivityResponse> findAllActivities();
}
