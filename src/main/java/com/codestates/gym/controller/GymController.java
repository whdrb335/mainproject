package com.codestates.gym.controller;

import com.codestates.gym.dto.GymPatchDto;
import com.codestates.gym.dto.GymPostDto;
import com.codestates.gym.dto.GymResponseDto;
import com.codestates.gym.entity.Gym;
import com.codestates.gym.mapper.GymMapper;
import com.codestates.gym.mapper.GymMapperImpl;
import com.codestates.gym.repository.GymRepository;
import com.codestates.gym.service.GymService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/gyms")
@Component
public class GymController {
    private final GymService gymService;
    private final GymMapper mapper;

    public GymController(GymService gymService, GymMapper mapper) {
        this.gymService = gymService;
        this.mapper = mapper;
    }


    @PostMapping
    public ResponseEntity postGym(@Valid @RequestBody GymPostDto gymPostDto) {
        Gym gym = mapper.gymPostDtoToGym(gymPostDto);
        gymService.createGym(gym);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    //     헬스장 정보 수정
    @PatchMapping("/{gym_id}")
    public ResponseEntity patchGym(@PathVariable("gym_id") @Positive long gymId,
                                   @Valid @RequestBody GymPatchDto gymPatchDto) {
        gymPatchDto.setGymId(gymId);

        Gym response =
                gymService.updateGym(mapper.gymPatchDtoToGym(gymPatchDto));

        return new ResponseEntity<>(mapper.gymToGymResponseDto(response), HttpStatus.OK);
    }


    // 헬스장 상세조회
    @GetMapping("/{gym_id}")
    public ResponseEntity getGym(@PathVariable("gym_id") @Positive long gymId) {

        Gym response = gymService.findGym(gymId);
        {
            return new ResponseEntity<>(mapper.gymToGymResponseDto(response), HttpStatus.OK);
        }

    }

    //헬스장 목록 조회
    @GetMapping
    public ResponseEntity getGyms() {
        // (7)
        List<Gym> response = gymService.findGyms();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


//    @GetMapping
//    public ResponseEntity getGyms() {
//        List<Gym> gyms = gymService.findGyms();
//
//        // (7) 매퍼를 이용해서 List<Member>를 MemberResponseDto로 변환
//        List<GymResponseDto> response =
//                gyms.stream()
//                        .map(gym -> mapper.gymToGymResponseDto(gym))
//                        .collect(Collectors.toList());
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

//
    @DeleteMapping("/{gym_id}")
    public ResponseEntity deleteGym(@PathVariable("gym_id") @Positive long gymId) {
        System.out.println("# deleted gymId: " + gymId);
        // No need business logic
        gymService.deleteGym(gymId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

//    @ExceptionHandler
//    public ResponseEntity handleException(MethodArgumentNotValidException e) {
//        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//
//        List<ErrorResponse.FieldError> errors =
//                fieldErrors.stream()
//                        .map(error -> new ErrorResponse.FieldError(
//                                error.getField(),
//                                error.getRejectedValue(),
//                                error.getDefaultMessage()))
//                        .collect(Collectors.toList());
//        return new ResponseEntity<>(new ErrorResponse(errors),HttpStatus.BAD_REQUEST);
//
//    }

    // 회원 정보는 구현해야 할 실습이 없습니다!

