package com.codestates.gym.entity;

//import com.codestates.member.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import main012.server.common.Auditable;
//import main012.server.user.entity.Member;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor // extends Auditable 해야함
public class GymReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gym_review_id")
    private Long id;

    private long grade;

    private String comment;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;
//
//    @ManyToOne
//    @JoinColumn(name = "gym_id")
//    private Gym gym;
}
