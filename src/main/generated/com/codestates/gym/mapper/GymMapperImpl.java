package com.codestates.gym.mapper;

import com.codestates.gym.dto.GymPatchDto;
import com.codestates.gym.dto.GymPostDto;
import com.codestates.gym.dto.GymResponseDto;
import com.codestates.gym.entity.Gym;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-21T10:40:26+0900",
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

        gym.setId( gymPatchDto.getId() );
        gym.setGymName( gymPatchDto.getGymName() );
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

        Long id = null;
        String gymName = null;
        String address = null;
        String phoneNumber = null;
        String businessHours = null;
        Double latitude = null;
        Double longitude = null;

        id = gym.getId();
        gymName = gym.getGymName();
        address = gym.getAddress();
        phoneNumber = gym.getPhoneNumber();
        businessHours = gym.getBusinessHours();
        latitude = gym.getLatitude();
        longitude = gym.getLongitude();

        GymResponseDto gymResponseDto = new GymResponseDto( id, gymName, address, phoneNumber, businessHours, latitude, longitude );

        return gymResponseDto;
    }

    @Override
    public List<GymResponseDto> gymsToGymResponseDtos(List<Gym> gyms) {
        if ( gyms == null ) {
            return null;
        }

        List<GymResponseDto> list = new ArrayList<GymResponseDto>( gyms.size() );
        for ( Gym gym : gyms ) {
            list.add( gymToGymResponseDto( gym ) );
        }

        return list;
    }
}
