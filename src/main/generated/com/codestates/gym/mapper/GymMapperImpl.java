package com.codestates.gym.mapper;

import com.codestates.gym.dto.GymPatchDto;
import com.codestates.gym.dto.GymPostDto;
import com.codestates.gym.dto.GymResponseDto;
import com.codestates.gym.entity.Gym;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-18T01:55:18+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class GymMapperImpl implements GymMapper {

    @Override
    public Gym gymPostDtoToGym(GymPostDto gymPostDto) {
        if ( gymPostDto == null ) {
            return null;
        }

        Gym gym = new Gym();

        gym.setGymName( gymPostDto.getGymName() );
        gym.setAddress( gymPostDto.getAddress() );
        gym.setPhoneNumber( gymPostDto.getPhoneNumber() );
        gym.setBusinessHours( gymPostDto.getBusinessHours() );
        if ( gymPostDto.getLatitude() != null ) {
            gym.setLatitude( gymPostDto.getLatitude() );
        }
        if ( gymPostDto.getLongitude() != null ) {
            gym.setLongitude( gymPostDto.getLongitude() );
        }

        return gym;
    }

    @Override
    public Gym gymPatchDtoToGym(GymPatchDto gymPatchDto) {
        if ( gymPatchDto == null ) {
            return null;
        }

        Gym gym = new Gym();

        gym.setGymId( gymPatchDto.getGymId() );
        gym.setAddress( gymPatchDto.getAddress() );
        gym.setPhoneNumber( gymPatchDto.getPhoneNumber() );
        gym.setBusinessHours( gymPatchDto.getBusinessHours() );
        if ( gymPatchDto.getLatitude() != null ) {
            gym.setLatitude( gymPatchDto.getLatitude() );
        }
        if ( gymPatchDto.getLongitude() != null ) {
            gym.setLongitude( gymPatchDto.getLongitude() );
        }

        return gym;
    }

    @Override
    public GymResponseDto gymToGymResponseDto(Gym gym) {
        if ( gym == null ) {
            return null;
        }

        long gymId = 0L;
        String gymName = null;
        String address = null;
        String phoneNumber = null;
        String businessHours = null;
        Double latitude = null;
        Double longitude = null;

        if ( gym.getGymId() != null ) {
            gymId = gym.getGymId();
        }
        gymName = gym.getGymName();
        address = gym.getAddress();
        phoneNumber = gym.getPhoneNumber();
        businessHours = gym.getBusinessHours();
        latitude = gym.getLatitude();
        longitude = gym.getLongitude();

        GymResponseDto gymResponseDto = new GymResponseDto( gymId, gymName, address, phoneNumber, businessHours, latitude, longitude );

        return gymResponseDto;
    }
}
