package com.codestates.gym.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_id")
    private Long id;

    private String facilityName;
    // 테이블 외래키 gymId 추가해서 참조, Gym클래스 (1) : 시설클래스 (N) 관계
//    private AggregateReference<Gym, Long> gymId;
}
