package com.codestates.gym.service;

import com.codestates.gym.entity.Gym;
import com.codestates.gym.exception.BusinessLoginException;
import com.codestates.gym.exception.ExceptionCode;

import com.codestates.gym.repository.GymRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Component
@Transactional

public class GymService {
    @Autowired
    private final GymRepository gymRepository;

    @Autowired
    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    public Gym createGym(Gym gym) {
        // 등록된 헬스장인지 검증
        verifyExistsGymName(gym.getGymName());
        return gymRepository.save(gym);
    }


    public Gym updateGym(Gym gym) {
        // 존재하는 헬스장인지 검증
        Gym findGym = findVerifiedGym(gym.getGymId());

        Optional.ofNullable(gym.getGymName())
                .ifPresent(gymName -> findGym.setGymName(gymName));
        Optional.ofNullable(gym.getAddress())
                .ifPresent(address -> findGym.setAddress(address));
        Optional.ofNullable(gym.getPhoneNumber())
                .ifPresent(phoneNumber -> findGym.setPhoneNumber(phoneNumber));
        Optional.ofNullable(gym.getBusinessHours())
                .ifPresent(businessHours -> findGym.setBusinessHours(businessHours));
        Optional.ofNullable(gym.getLatitude())
                .ifPresent(latitude -> findGym.setLatitude(latitude));
        Optional.ofNullable(gym.getLongitude())
                .ifPresent(longitude -> findGym.setLongitude(longitude));
        return gymRepository.save(findGym);
    }

    // 상세 헬스장 조회
    public Gym findGym(long gymId) {
        return findVerifiedGym(gymId);
    }

    // 모든 헬스장 정보 조회
    public List<Gym> findGyms() {

        return (List<Gym>) gymRepository.findAll();
    }
    // 특정 헬스장 삭제
    public void deleteGym(long gymId){
        Gym findGym = findVerifiedGym(gymId);
        gymRepository.delete(findGym);

    }
    // 이미 존재하는 헬스장인지 검증
    public Gym findVerifiedGym(long gymId) {
        Optional<Gym> optionalGym =
                gymRepository.findById(gymId);
        Gym findGym =
                optionalGym.orElseThrow(() ->
                        new BusinessLoginException(ExceptionCode.GYM_NOT_FOUND));
        return findGym;
    }

    // 이미 등록된 이름인지 검증
    private void verifyExistsGymName(String gymName) {
        Optional<Gym> gym = gymRepository.findByGymName(gymName);
        if (gym.isPresent())
            throw new BusinessLoginException(ExceptionCode.GYM_EXISTS);
    }
}
