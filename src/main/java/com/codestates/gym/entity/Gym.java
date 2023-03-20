package com.codestates.gym.entity;


import com.codestates.common.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@AllArgsConstructor
public class Gym extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gymId;
    @Column(nullable = false, updatable = false,unique = true) // 헬스장 이름은 unique
    private String gymName;
    private String address;
    private String phoneNumber;
    private String businessHours;
    private double latitude;
    private double longitude;

    public Gym(String gymName) {
        this.gymName = gymName;
    }




}







