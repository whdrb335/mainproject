package com.codestates.gym.entity;


import com.codestates.common.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Gym extends Auditable {
    @Id
    @Column(name = "gym_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false, updatable = false,unique = true) // 헬스장 이름은 unique
    private String gymName;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(length = 15,nullable = false)
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    private String businessHours;
    @Column(length = 30, nullable = false)
    private double latitude;
    @Column(length = 30, nullable = false)
    private double longitude;

    public Gym(String gymName) {
        this.gymName = gymName;
    }

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "gym", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<GymReview> gymReviews = new ArrayList<>();

    public void setGymReview(GymReview gymReview){
        this.gymReviews.add(gymReview);
        if(gymReview.getGym() != this) {
            gymReview.setGym(this);
        }
    }





}







