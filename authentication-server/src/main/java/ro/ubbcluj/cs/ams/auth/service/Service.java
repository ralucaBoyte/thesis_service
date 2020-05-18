package ro.ubbcluj.cs.ams.auth.service;

import org.jooq.Record;
import ro.ubbcluj.cs.ams.auth.dto.*;
import ro.ubbcluj.cs.ams.auth.model.tables.records.OauthUserRecord;

import java.util.List;

public interface Service {
    List<ReviewResponse> findAllReviewsForProfessor(String professor);
    Integer addReviewForProfessor(ReviewAddedDto reviewAddedDto, String student);
    List<ProfessorResponse> getAllProfessor();
    Integer saveUserKeyphrase(UserDto userDto);
    Integer existsUserKeyphraseForGivenUser(String username);
    UserKeyphraseResponse getUserKeyphrase(String username);
}
