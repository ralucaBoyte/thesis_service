package ro.ubbcluj.cs.ams.auth.service;

import ro.ubbcluj.cs.ams.auth.dto.ReviewResponse;
import ro.ubbcluj.cs.ams.auth.dto.UserDto;
import ro.ubbcluj.cs.ams.auth.dto.UserKeyphraseResponse;

import java.util.List;

public interface Service {
    List<ReviewResponse> findAllReviewsForProfessor(String professor);
    Integer saveUserKeyphrase(UserDto userDto);
    Integer existsUserKeyphraseForGivenUser(String username);
    UserKeyphraseResponse getUserKeyphrase(String username);
}
