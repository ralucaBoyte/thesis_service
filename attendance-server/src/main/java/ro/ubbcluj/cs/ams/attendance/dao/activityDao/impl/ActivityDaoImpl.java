package ro.ubbcluj.cs.ams.attendance.dao.activityDao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.attendance.dao.activityDao.ActivityDao;
import ro.ubbcluj.cs.ams.attendance.model.Tables;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.ActivityRecord;

import java.util.List;

@Component
public class ActivityDaoImpl implements ActivityDao {

    @Autowired
    private DSLContext dsl;

    private final Logger logger = LogManager.getLogger(ActivityDaoImpl.class);

    @Override
    public List<ActivityRecord> getAllActivities() {
        logger.info("++++++++ LOGGING find all subject ++++++++");

        List<ActivityRecord> activities = dsl.selectFrom(Tables.ACTIVITY)
                .fetch();
        return activities;
    }
}
