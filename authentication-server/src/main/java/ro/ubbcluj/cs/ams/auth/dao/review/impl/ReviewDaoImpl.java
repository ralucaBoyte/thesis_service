package ro.ubbcluj.cs.ams.auth.dao.review.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.auth.dao.review.ReviewDao;
import ro.ubbcluj.cs.ams.auth.model.Tables;
import ro.ubbcluj.cs.ams.auth.model.tables.records.ReviewsRecord;

import java.util.List;

@Component
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private DSLContext dsl;

    private final Logger logger = LogManager.getLogger(ReviewDaoImpl.class);

    @Override
    public List<ReviewsRecord> getAllReviewsForProfessor(String professor) {
      logger.info("++++++++++++GET ALL REVIEWW FOR PROFESSOR +++++++");

      List<ReviewsRecord> reviewsRecords = dsl.selectFrom(Tables.REVIEWS)
                .where(Tables.REVIEWS.PROFESSOR.eq(professor))
                .fetch();
      return reviewsRecords;
    }

//    @Override
//    public List<ActivityRecord> getAllActivities() {
//        logger.info("++++++++ LOGGING find all subject ++++++++");
//
//        List<ActivityRecord> activities = dsl.selectFrom(Tables.ACTIVITY)
//                .fetch();
//        return activities;
//    }
}