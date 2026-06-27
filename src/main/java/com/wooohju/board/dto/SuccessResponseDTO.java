package com.wooohju.board.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SuccessResponseDTO {
    String message;

    public static SuccessResponseDTO created()
    {
        return SuccessResponseDTO.builder()
                .message("성공적으로 등록됐습니다.")
                .build();
    }
}
