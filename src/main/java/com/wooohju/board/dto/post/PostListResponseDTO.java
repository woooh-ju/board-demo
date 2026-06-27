package com.wooohju.board.dto.post;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PostListResponseDTO {

    List<PostResponseDTO> postList;

    public static PostListResponseDTO from(List<PostResponseDTO> postResponseDTOList)
    {
        return PostListResponseDTO.builder()
                .postList(postResponseDTOList)
                .build();
    }
}
