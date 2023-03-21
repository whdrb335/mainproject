package com.codestates.gym.service;

import com.codestates.exception.BusinessLoginException;
import com.codestates.exception.ExceptionCode;
import com.codestates.gym.entity.GymReview;
import com.codestates.gym.repository.GymReviewRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor // 생성자 주입
public class GymReviewService {
    private final GymReviewRepository gymReviewRepository;

    public GymReview createGymReview(GymReview gymReview) {

        return gymReviewRepository.save(gymReview); //DB에 저장
    }


    public GymReview updateGymReview(GymReview gymReview) {
        GymReview findGymReview = findVerifiedGymReview(gymReview.getId());

        Optional.ofNullable(gymReview.getGymGrade())
                .ifPresent(gymReviewGrade -> findGymReview.setGymGrade(gymReviewGrade)); //같은 게시글이 아닐경우 에러처리
        return gymReviewRepository.save(findGymReview);
    }

    public GymReview findVerifiedGymReview(long gymReviewId) {
        Optional<GymReview> optionalGymReview =
                gymReviewRepository.findById(gymReviewId);
        GymReview findGymReview =
                optionalGymReview.orElseThrow(() ->
                        new BusinessLoginException(ExceptionCode.GYMREVIEW_NOT_FOUND));
        return findGymReview;
    }

//    // 리뷰 조회
//    public Page<GymReview> findGymReviews(int page, int size) {
//        return gymReviewRepository.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
//    }
    /*게시글 페이지 조회*/
    public Page<GymReview> gymReviewPage(Pageable pageable){
        // .findAll - 해당 페이지 형식에 맞춰서 모든 리뷰 가져오기
        return gymReviewRepository.findAll(pageable);
    }
}
