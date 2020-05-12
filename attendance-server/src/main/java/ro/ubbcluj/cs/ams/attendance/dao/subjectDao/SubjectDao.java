package ro.ubbcluj.cs.ams.attendance.dao.subjectDao;

import ro.ubbcluj.cs.ams.attendance.model.tables.records.SubjectRecord;

import java.util.List;

public interface SubjectDao {
    List<SubjectRecord> getAllSubjects();
}
