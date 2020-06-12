package ro.ubbcluj.cs.ams.attendance.dao.attendanceDao;

import org.jooq.Record;
import ro.ubbcluj.cs.ams.attendance.dto.AttendanceResponse;
import ro.ubbcluj.cs.ams.attendance.dto.AttendanceResponseForStudent;
import ro.ubbcluj.cs.ams.attendance.dto.AttendanceResponseForView;
import ro.ubbcluj.cs.ams.attendance.model.tables.pojos.Attendance;
import ro.ubbcluj.cs.ams.attendance.model.tables.pojos.AttendanceInfo;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceInfoRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceRecord;

import java.util.List;

public interface AttendanceDao {

    AttendanceRecord addAttendance(Attendance attendance);
    String getCourseForCertainAttendance(AttendanceInfoRecord attendance);
    String getActivityForCertainAttendance(AttendanceInfoRecord attendance);
    List<AttendanceResponse> getAllAttendances();
    List<AttendanceResponseForView> getAllAttendancesForCourseAndWeek(Integer course_id, Integer activity_id, Integer week);
    List<AttendanceResponseForStudent> getAllAttendancesForStudent(String student);

}
