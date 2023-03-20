package com.codestates.gym.mapper;

import com.codestates.gym.dto.GymPatchDto;
import com.codestates.gym.dto.GymPostDto;
import com.codestates.gym.dto.GymResponseDto;
import com.codestates.gym.entity.Gym;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
//@Component
public interface GymMapper {


    Gym gymPostDtoToGym(GymPostDto gymPostDto);
    Gym gymPatchDtoToGym(GymPatchDto gymPatchDto);
    GymResponseDto gymToGymResponseDto(Gym gym);
    List<GymResponseDto> gymsToGymResponseDtos(List<Gym> gyms);

}
