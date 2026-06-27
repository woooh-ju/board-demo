package com.wooohju.board.global;

import com.wooohju.board.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handlePostNotFound()
    {
        return ErrorResponseDTO.created(HttpStatus.NOT_FOUND.value(), "POST_NOT_FOUND", "존재하지 않는 게시글입니다.");
    }
}
