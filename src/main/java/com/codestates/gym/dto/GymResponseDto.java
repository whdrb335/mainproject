package com.codestates.gym.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GymResponseDto {
    private long gymId;
    private String gymName;
    private String address;
    private String phoneNumber;
    private String businessHours;
    private Double latitude;

    private Double longitude;
}