package ro.ubbcluj.cs.ams.attendance.dto;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.attendance.dto.ActivityResponse.ActivityResponseBuilder;
import ro.ubbcluj.cs.ams.attendance.dto.SubjectResponse.SubjectResponseBuilder;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.ActivityRecord;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.SubjectRecord;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-12T18:53:32+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 10.0.2 (Oracle Corporation)"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public List<SubjectResponse> mapToSubjects(List<SubjectRecord> subjectRecords) {
        if ( subjectRecords == null ) {
            return null;
        }

        List<SubjectResponse> list = new ArrayList<SubjectResponse>( subjectRecords.size() );
        for ( SubjectRecord subjectRecord : subjectRecords ) {
            list.add( subjectRecordToSubjectResponse( subjectRecord ) );
        }

        return list;
    }

    @Override
    public List<ActivityResponse> mapToActivities(List<ActivityRecord> activityRecords) {
        if ( activityRecords == null ) {
            return null;
        }

        List<ActivityResponse> list = new ArrayList<ActivityResponse>( activityRecords.size() );
        for ( ActivityRecord activityRecord : activityRecords ) {
            list.add( activityRecordToActivityResponse( activityRecord ) );
        }

        return list;
    }

    protected SubjectResponse subjectRecordToSubjectResponse(SubjectRecord subjectRecord) {
        if ( subjectRecord == null ) {
            return null;
        }

        SubjectResponseBuilder subjectResponse = SubjectResponse.builder();

        subjectResponse.id( subjectRecord.getId() );
        subjectResponse.name( subjectRecord.getName() );
        subjectResponse.credits( subjectRecord.getCredits() );
        subjectResponse.year( subjectRecord.getYear() );

        return subjectResponse.build();
    }

    protected ActivityResponse activityRecordToActivityResponse(ActivityRecord activityRecord) {
        if ( activityRecord == null ) {
            return null;
        }

        ActivityResponseBuilder activityResponse = ActivityResponse.builder();

        activityResponse.id( activityRecord.getId() );
        activityResponse.type( activityRecord.getType() );

        return activityResponse.build();
    }
}
