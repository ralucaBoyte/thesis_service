package ro.ubbcluj.cs.ams.auth.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import ro.ubbcluj.cs.ams.auth.dao.review.ReviewDao;
import ro.ubbcluj.cs.ams.auth.dao.user.UserDao;
import ro.ubbcluj.cs.ams.auth.dto.*;
import ro.ubbcluj.cs.ams.auth.model.tables.records.OauthUserRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.ReviewsRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.UserKeyphraseRecord;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReviewDao reviewDao;

    @Autowired
    private UserDao userDao;


    private Logger logger = LogManager.getLogger(ServiceImpl.class);

    @Override
    public List<ReviewResponse> findAllReviewsForProfessor(String professor) {
        logger.info("+++++++++ find all subjects in service +++++++");


        List<ReviewsRecord> reviewsRecords = reviewDao.getAllReviewsForProfessor(professor);

        return reviewMapper.mapToReviews(reviewsRecords);
    }

    @Override
    public Integer addReviewForProfessor(ReviewAddedDto reviewAddedDto, String student) {
        logger.info("+++++++++ save new review for professor +++++++");
        Integer reviewAdded = reviewDao.addReviewForTeacher(reviewAddedDto, student);
        return reviewAdded;
    }

    @Override
    public List<ProfessorResponse> getAllProfessor() {
        logger.info("+++++++++ get allprofessors +++++++");
        List<OauthUserRecord> professors = userDao.getAllProfessors();
        return userMapper.mapOauthUsersToProfessors(professors);
       // return professors;
    }


    @Override
    public Integer saveUserKeyphrase(UserDto userDto) {
        logger.info("+++++++++ save new record in user_keyphrase +++++++");
        Integer userKeyphraseAdded = userDao.saveUserKeyphrase(userDto);
        return userKeyphraseAdded;
    }


    @Override
    public Integer existsUserKeyphraseForGivenUser(String username) {
        logger.info("+++++++++ CHECK IF EXISTS USER_KEYPHRASE +++++++");
        Integer userKeyphrase = userDao.getUserKeyphraseForUsername(username);
        return userKeyphrase;
    }

    @Override
    public UserKeyphraseResponse getUserKeyphrase(String username) {
        logger.info("+++++++++ GET USER KEYPHRASE +++++++");
        UserKeyphraseRecord userKeyphraseRecord = userDao.getUserKeyphraseForUser(username);
        return userMapper.mapToUserKeyphrase(userKeyphraseRecord);
    }


}
