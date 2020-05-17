package ro.ubbcluj.cs.ams.auth.service;

import org.mapstruct.Mapper;
import ro.ubbcluj.cs.ams.auth.dto.ReviewResponse;
import ro.ubbcluj.cs.ams.auth.dto.UserKeyphraseResponse;
import ro.ubbcluj.cs.ams.auth.model.tables.records.OauthUserRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.ReviewsRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.UserKeyphraseRecord;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<ReviewResponse> mapToReviews(List<ReviewsRecord> reviewsRecords);
    UserKeyphraseResponse mapToUserKeyphrase(UserKeyphraseRecord userKeyphraseRecord);
    }