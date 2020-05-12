package ro.ubbcluj.cs.ams.attendance.dao.attendanceDao;

import ro.ubbcluj.cs.ams.attendance.model.tables.pojos.Attendance;
import ro.ubbcluj.cs.ams.attendance.model.tables.pojos.AttendanceInfo;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceInfoRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceRecord;

public interface AttendanceDao {

    AttendanceRecord addAttendance(Attendance attendance);
    String getCourseForCertainAttendance(AttendanceInfoRecord attendance);
    String getActivityForCertainAttendance(AttendanceInfoRecord attendance);

}
