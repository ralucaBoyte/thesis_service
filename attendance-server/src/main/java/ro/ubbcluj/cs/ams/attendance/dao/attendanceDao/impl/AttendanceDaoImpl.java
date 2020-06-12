package ro.ubbcluj.cs.ams.attendance.dao.attendanceDao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.attendance.dao.attendanceDao.AttendanceDao;
import ro.ubbcluj.cs.ams.attendance.dao.attendanceInfoDao.impl.AttendanceInfoDaoImpl;
import ro.ubbcluj.cs.ams.attendance.dto.AttendanceResponse;
import ro.ubbcluj.cs.ams.attendance.dto.AttendanceResponseForStudent;
import ro.ubbcluj.cs.ams.attendance.dto.AttendanceResponseForView;
import ro.ubbcluj.cs.ams.attendance.model.Tables;
import ro.ubbcluj.cs.ams.attendance.model.tables.pojos.Attendance;
import ro.ubbcluj.cs.ams.attendance.model.tables.pojos.AttendanceInfo;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.ActivityRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceInfoRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.SubjectRecord;

import java.util.List;


@Component
public class AttendanceDaoImpl implements AttendanceDao {

    @Autowired
    private DSLContext dsl;

    private final Logger logger = LogManager.getLogger(AttendanceInfoDaoImpl.class);


    @Override
    public AttendanceRecord addAttendance(Attendance attendance) {

        logger.info("+++++++++++ Before addAttendance :" + attendance + "++++++++++++++++");

        AttendanceRecord attendanceRecord = dsl.insertInto(Tables.ATTENDANCE, Tables.ATTENDANCE.STUDENT_ID, Tables.ATTENDANCE.CREATED_AT, Tables.ATTENDANCE.ATTENDANCE_INFO_ID)
                .values(attendance.getStudentId(), attendance.getCreatedAt(), attendance.getAttendanceInfoId())
                .returning()
                .fetchOne();

        logger.info("+++++ After add action ++++++++++");
        return attendanceRecord;
    }

    @Override
    public String getCourseForCertainAttendance(AttendanceInfoRecord attendanceInfoRecord) {
        logger.info("+++++++++++ GET course name for certain attendance info :" + attendanceInfoRecord + "++++++++++++++++");

        SubjectRecord subjectRecord = dsl.selectFrom(Tables.SUBJECT)
                .where(Tables.SUBJECT.ID.eq(attendanceInfoRecord.component2()))
                .fetchOne();

        return subjectRecord.component2();

    }

    @Override
    public String getActivityForCertainAttendance(AttendanceInfoRecord attendanceInfoRecord) {
        logger.info("+++++++++++ GET activity type for certain attendance info :" + attendanceInfoRecord + "++++++++++++++++");

        ActivityRecord activityRecord = dsl.selectFrom(Tables.ACTIVITY)
                .where(Tables.ACTIVITY.ID.eq(attendanceInfoRecord.component3()))
                .fetchOne();

        return activityRecord.component2();
    }

    @Override
    public List<AttendanceResponse> getAllAttendances() {
        logger.info("+++++++++++ GET all attendances:++++++++++++++++");

        List<AttendanceResponse> attendanceRecords = dsl.select()
                .from(Tables.ATTENDANCE)
                .join(Tables.ATTENDANCE_INFO).on(Tables.ATTENDANCE.ATTENDANCE_INFO_ID.eq(Tables.ATTENDANCE_INFO.ID))
                .join(Tables.SUBJECT).on(Tables.ATTENDANCE_INFO.COURSE_ID.eq(Tables.SUBJECT.ID))
                .join(Tables.ACTIVITY).on(Tables.ATTENDANCE_INFO.ACTIVITY_ID.eq(Tables.ACTIVITY.ID))
                .fetchInto(AttendanceResponse.class);

        return attendanceRecords;
    }

    @Override
    public List<AttendanceResponseForView> getAllAttendancesForCourseAndWeek(Integer course_id, Integer activity_id, Integer week) {

        List<AttendanceResponseForView> attendanceResponses = dsl.select()
            .from(Tables.ATTENDANCE)
            .join(Tables.ATTENDANCE_INFO)
                .on(Tables.ATTENDANCE.ATTENDANCE_INFO_ID.eq(Tables.ATTENDANCE_INFO.ID))
            .join(Tables.SUBJECT)
                .on(Tables.ATTENDANCE_INFO.COURSE_ID.eq(Tables.SUBJECT.ID))
            .join(Tables.ACTIVITY)
                .on(Tables.ATTENDANCE_INFO.ACTIVITY_ID.eq(Tables.ACTIVITY.ID))
            .where(Tables.ATTENDANCE_INFO.WEEK.eq(week).and(Tables.SUBJECT.ID.eq(course_id))
                    .and(Tables.ATTENDANCE_INFO.ACTIVITY_ID.eq(activity_id)))
            .fetchInto(AttendanceResponseForView.class);

        return attendanceResponses;
    }

    @Override
    public List<AttendanceResponseForStudent> getAllAttendancesForStudent(String student) {
        List<AttendanceResponseForStudent> attendanceResponses = dsl.select()
                .from(Tables.ATTENDANCE)
                .join(Tables.ATTENDANCE_INFO)
                .on(Tables.ATTENDANCE.ATTENDANCE_INFO_ID.eq(Tables.ATTENDANCE_INFO.ID))
                .join(Tables.SUBJECT)
                .on(Tables.ATTENDANCE_INFO.COURSE_ID.eq(Tables.SUBJECT.ID))
                .join(Tables.ACTIVITY)
                .on(Tables.ATTENDANCE_INFO.ACTIVITY_ID.eq(Tables.ACTIVITY.ID))
                .where(Tables.ATTENDANCE.STUDENT_ID.eq(student))
                .orderBy(Tables.ATTENDANCE_INFO.COURSE_ID)
                .fetchInto(AttendanceResponseForStudent.class);

        return attendanceResponses;
    }


}
