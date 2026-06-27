package com.wooohju.board.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponseDTO {
    @JsonProperty("status_code")
    int statusCode;

    String error;
    String message;

    public static ErrorResponseDTO created(int statusCode, String error, String message)
    {
        return ErrorResponseDTO.builder()
                .statusCode(statusCode)
                .error(error)
                .message(message)
                .build();
    }
}
