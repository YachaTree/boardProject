package com.Tree_dev.workout_done.post.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ExceptionCode {
    POST_NOT_FOUND(404, "존재하지 않는 게시글입니다."),
    POST_EXISTS(409, "이미 존재하는 게시글입니다.");

    @Getter
    private int status;

    @Getter
    private String message;
}
