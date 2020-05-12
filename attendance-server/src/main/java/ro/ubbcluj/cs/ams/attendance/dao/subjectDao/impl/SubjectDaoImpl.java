package ro.ubbcluj.cs.ams.attendance.dao.subjectDao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.attendance.dao.subjectDao.SubjectDao;
import ro.ubbcluj.cs.ams.attendance.model.Tables;
import ro.ubbcluj.cs.ams.attendance.model.tables.records.SubjectRecord;

import java.util.List;

@Component
public class SubjectDaoImpl implements SubjectDao {

    @Autowired
    private DSLContext dsl;

    private final Logger logger = LogManager.getLogger(SubjectDaoImpl.class);

    @Override
    public List<SubjectRecord> getAllSubjects() {
        logger.info("++++++++ LOGGING find all subject ++++++++");

        List<SubjectRecord> subjects = dsl.selectFrom(Tables.SUBJECT)
                .fetch();
        return subjects;
    }
}
