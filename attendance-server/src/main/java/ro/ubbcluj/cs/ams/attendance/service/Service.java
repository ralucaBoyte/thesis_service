package ro.ubbcluj.cs.ams.attendance.service;

import ro.ubbcluj.cs.ams.attendance.dto.*;

import java.util.List;

public interface Service {

    AttendanceInfoResponse addAttendanceInfo(AttendanceInfoReq attendanceInfoReq, String username);

    StudentAttendanceResponse addAttendance(AttendanceRequest attendanceRequest, String username);

    List<SubjectResponse> findAllSubjects();
    List<ActivityResponse> findAllActivities();
}
