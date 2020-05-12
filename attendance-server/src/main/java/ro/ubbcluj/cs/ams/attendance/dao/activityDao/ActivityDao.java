package ro.ubbcluj.cs.ams.attendance.dao.activityDao;

import ro.ubbcluj.cs.ams.attendance.model.tables.records.ActivityRecord;

import java.util.List;

public interface ActivityDao {
    List<ActivityRecord> getAllActivities();
}
