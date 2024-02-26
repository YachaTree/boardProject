package com.Tree_dev.workout_done.common.exception;

import com.Tree_dev.workout_done.common.exception.ExceptionCode;
import lombok.Getter;

public class ServiceLogicException extends RuntimeException {

    @Getter
    private final ExceptionCode boardExceptionCode;

    public ServiceLogicException(ExceptionCode boardExceptionCode) {
        super(boardExceptionCode.getMessage());
        this.boardExceptionCode = boardExceptionCode;
    }

}

