package ro.ubbcluj.cs.ams.attendance.dto;

import org.jooq.Record;
import org.mapstruct.Mapper;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.ActivityRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.AttendanceRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.SubjectRecord;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    List<SubjectResponse> mapToSubjects(List<SubjectRecord> subjectRecords);
    List<ActivityResponse> mapToActivities(List<ActivityRecord> activityRecords);
    List<AttendanceResponse> mapToAttendances(List<Record> attendanceRecords);

}
