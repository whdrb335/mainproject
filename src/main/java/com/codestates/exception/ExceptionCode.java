package com.codestates.exception;

import lombok.Getter;

public enum ExceptionCode {
    GYMREVIEW_NOT_FOUND(404,"GymReview Not Found"),
    GYM_NOT_FOUND(404, "Gym Not Found"),
    GYM_EXISTS(409, "GYM exists");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
