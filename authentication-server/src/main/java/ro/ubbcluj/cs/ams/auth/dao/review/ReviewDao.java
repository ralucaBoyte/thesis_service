package ro.ubbcluj.cs.ams.auth.dao.review;

import ro.ubbcluj.cs.ams.auth.model.tables.records.ReviewsRecord;

import java.util.List;

public interface ReviewDao {
    List<ReviewsRecord> getAllReviewsForProfessor(String username);
}
