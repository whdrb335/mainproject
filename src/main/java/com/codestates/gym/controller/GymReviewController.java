package com.codestates.gym.controller;

import com.codestates.dto.MultiResponseDto;
import com.codestates.gym.dto.GymReviewPatchDto;
import com.codestates.gym.dto.GymReviewPostDto;
import com.codestates.gym.dto.GymReviewResponseDto;
import com.codestates.gym.entity.GymReview;

import com.codestates.gym.mapper.GymReviewMapper;
import com.codestates.gym.service.GymReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController // json 형태 변환
@RequestMapping("/gyms/reviews") // 공통적인 URL
@RequiredArgsConstructor // final 이나 @NotNull 이 붙은 필드의 생성자를 자동 생성
@Validated // 유효성 검증 대신 뒤에 메소드의 파라미터에 @Valid 를 붙여줘야 유효성 검증된다.

public class GymReviewController {
    private final GymReviewService gymReviewService;
    private final GymReviewMapper mapper;



//     gym_id 번 헬스장에 리뷰 등록
    @PostMapping("{gym_id}")
    public ResponseEntity<?> postGymReview(@Valid @RequestBody GymReviewPostDto gymReviewPostDto)
    {
        GymReview gymReview = mapper.gymReviewPostDtoToGymReview(gymReviewPostDto); //DTO -> Entity 변환
        GymReview createGymReview = gymReviewService.createGymReview(gymReview); //테이블 저장
        GymReviewResponseDto response = mapper.gymReviewResponseDtoToGymReview(createGymReview); //Entity -> ResponseDto

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PatchMapping("{review_id}")
    public ResponseEntity patchGymReview(@PathVariable("review_id") @Positive Long id,
                                         @Valid @RequestBody GymReviewPatchDto gymReviewPatchDto){
        gymReviewPatchDto.setId(id);

        GymReview response =
                gymReviewService.updateGymReview(mapper.gymReviewPatchDtoToGymReview(gymReviewPatchDto));
        return new ResponseEntity<>(mapper.gymReviewResponseDtoToGymReview(response), HttpStatus.OK);
    }

//    // 리뷰 조회
//    @GetMapping("{gym_id}")
//    public ResponseEntity getGymsReviews(@Positive @RequestParam int page,
//                                         @Positive @RequestParam int size) {
//        Page<GymReview> pageGymReviews = gymReviewService.findGymReviews(page-1,size);
//        List<GymReview> gymReviews = pageGymReviews.getContent();
//        return new ResponseEntity<>(
//                new MultiResponseDto<>(mapper.gymReviewsToGymResponseDtos(gymReviews),
//                        pageGymReviews),
//                HttpStatus.OK);
//
//    }

    @GetMapping("{gym_id}")
    public ResponseEntity getGymReviews(@PathVariable("gym_id") @Positive long Id,
                                        @PageableDefault(size=10, sort = "createdAt", direction = Sort.Direction.DESC)Pageable pageable) {

        Page<GymReview> gymReviewPage = gymReviewService.gymReviewPage(pageable); //페이지형식으로 모든 리뷰를 받아온다
        List<GymReview> gymReviews = gymReviewPage.getContent(); // 받아온 리뷰를 리스트형식으로 바꾼다.
        List<GymReviewResponseDto> response = mapper.gymReviewsToGymResponseDtos(gymReviews);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }



}
