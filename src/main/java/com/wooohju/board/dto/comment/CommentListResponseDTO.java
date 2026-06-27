package com.wooohju.board.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wooohju.board.dto.post.PostListResponseDTO;
import com.wooohju.board.dto.post.PostResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CommentListResponseDTO {
    @JsonProperty("comments")
    List<CommentResponseDTO> commentListDTO;

    public static CommentListResponseDTO from(List<CommentResponseDTO> commentResponseDTOList)
    {
        return CommentListResponseDTO.builder()
                .commentListDTO(commentResponseDTOList)
                .build();
    }
}
