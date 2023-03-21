package com.codestates.gym.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class GymReviewPatchDto {
    private Long id;

    @NotBlank(message = "평점을 입력해 주세요")
    private long grade;

    @NotBlank(message = "리뷰를 작성해 주세요")
    private String comment;

    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
