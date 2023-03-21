package com.codestates.gym.mapper;

import com.codestates.gym.dto.GymReviewPatchDto;
import com.codestates.gym.dto.GymReviewPostDto;
import com.codestates.gym.dto.GymReviewResponseDto;
import com.codestates.gym.entity.GymReview;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GymReviewMapper {

    GymReview gymReviewPostDtoToGymReview(GymReviewPostDto gymReviewPostDto);
    GymReview gymReviewPatchDtoToGymReview(GymReviewPatchDto gymReviewPatchDto);
    GymReviewResponseDto gymReviewResponseDtoToGymReview(GymReview gymReview);
    List<GymReviewResponseDto> gymReviewsToGymResponseDtos(List<GymReview> gymReviews);


}
