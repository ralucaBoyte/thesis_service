package ro.ubbcluj.cs.ams.attendance.dao.attendanceDao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.attendance.dao.attendanceDao.AttendanceDao;
import ro.ubbcluj.cs.ams.attendance.dao.attendanceInfoDao.impl.AttendanceInfoDaoImpl;
import ro.ubbcluj.cs.ams.attendance.model.Tables;
import ro.ubbcluj.cs.ams.attendance.model.tables.pojos.Attendance;
import ro.ubbcluj.cs.ams.attendance.model.tables.pojos.AttendanceInfo;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.ActivityRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceInfoRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.SubjectRecord;


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
}
