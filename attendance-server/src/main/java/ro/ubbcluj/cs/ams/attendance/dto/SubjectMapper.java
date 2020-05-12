package ro.ubbcluj.cs.ams.attendance.dto;

import org.mapstruct.Mapper;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.ActivityRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.SubjectRecord;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    List<SubjectResponse> mapToSubjects(List<SubjectRecord> subjectRecords);
    List<ActivityResponse> mapToActivities(List<ActivityRecord> activityRecords);


}
