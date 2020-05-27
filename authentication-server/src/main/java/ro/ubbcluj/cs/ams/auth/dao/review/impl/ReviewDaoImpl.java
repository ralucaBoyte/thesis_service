package ro.ubbcluj.cs.ams.auth.dao.review.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.DSLContext;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.auth.dao.review.ReviewDao;
import ro.ubbcluj.cs.ams.auth.dto.ReviewAddedDto;
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

    @Override
    public Integer addReviewForTeacher(ReviewAddedDto reviewAddedDto, String student) {
        logger.info("++++++++++++ADD REVIEWW FOR PROFESSOR +++++++");

        try {
            Integer addReview = dsl.insertInto(Tables.REVIEWS, Tables.REVIEWS.PROFESSOR,
                    Tables.REVIEWS.STUDENT, Tables.REVIEWS.FEEDBACK, Tables.REVIEWS.REVIEW_GRADE)
                    .values(reviewAddedDto.getProfessor(), student, reviewAddedDto.getFeedback(), reviewAddedDto.getReviewGrade())
                    .execute();
            return addReview;
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            return 0;
        }
    }

}