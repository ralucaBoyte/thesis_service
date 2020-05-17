package ro.ubbcluj.cs.ams.auth.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import ro.ubbcluj.cs.ams.auth.dto.ReviewResponse;
import ro.ubbcluj.cs.ams.auth.dto.ReviewResponse.ReviewResponseBuilder;
import ro.ubbcluj.cs.ams.auth.dto.UserKeyphraseResponse;
import ro.ubbcluj.cs.ams.auth.dto.UserKeyphraseResponse.UserKeyphraseResponseBuilder;
import ro.ubbcluj.cs.ams.auth.model.tables.records.ReviewsRecord;
import ro.ubbcluj.cs.ams.auth.model.tables.records.UserKeyphraseRecord;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-17T20:38:16+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 10.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public List<ReviewResponse> mapToReviews(List<ReviewsRecord> reviewsRecords) {
        if ( reviewsRecords == null ) {
            return null;
        }

        List<ReviewResponse> list = new ArrayList<ReviewResponse>( reviewsRecords.size() );
        for ( ReviewsRecord reviewsRecord : reviewsRecords ) {
            list.add( reviewsRecordToReviewResponse( reviewsRecord ) );
        }

        return list;
    }

    @Override
    public UserKeyphraseResponse mapToUserKeyphrase(UserKeyphraseRecord userKeyphraseRecord) {
        if ( userKeyphraseRecord == null ) {
            return null;
        }

        UserKeyphraseResponseBuilder userKeyphraseResponse = UserKeyphraseResponse.builder();

        userKeyphraseResponse.username( userKeyphraseRecord.getUsername() );
        userKeyphraseResponse.message( userKeyphraseRecord.getMessage() );
        userKeyphraseResponse.keyphrase( userKeyphraseRecord.getKeyphrase() );

        return userKeyphraseResponse.build();
    }

    protected ReviewResponse reviewsRecordToReviewResponse(ReviewsRecord reviewsRecord) {
        if ( reviewsRecord == null ) {
            return null;
        }

        ReviewResponseBuilder reviewResponse = ReviewResponse.builder();

        reviewResponse.student( reviewsRecord.getStudent() );
        reviewResponse.feedback( reviewsRecord.getFeedback() );
        reviewResponse.reviewGrade( reviewsRecord.getReviewGrade() );

        return reviewResponse.build();
    }
}
