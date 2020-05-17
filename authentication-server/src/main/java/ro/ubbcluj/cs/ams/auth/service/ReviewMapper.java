package ro.ubbcluj.cs.ams.auth.service;

import org.mapstruct.Mapper;
import ro.ubbcluj.cs.ams.auth.dto.ReviewResponse;
import ro.ubbcluj.cs.ams.auth.model.tables.records.ReviewsRecord;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    List<ReviewResponse> mapToReviews(List<ReviewsRecord> reviewsRecords);

}
