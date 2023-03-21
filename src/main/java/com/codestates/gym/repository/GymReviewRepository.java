package com.codestates.gym.repository;

import com.codestates.gym.entity.GymReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
@EnableJpaRepositories
public interface GymReviewRepository extends JpaRepository<GymReview, Long> {

}
