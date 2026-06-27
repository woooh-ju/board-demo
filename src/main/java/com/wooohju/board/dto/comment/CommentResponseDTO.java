package com.wooohju.board.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wooohju.board.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CommentResponseDTO {
    Long id;
    String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("create_date")
    LocalDate createDate;

    Long post;

    public static CommentResponseDTO from(Comment comment)
    {
        return CommentResponseDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createDate(comment.getCreateDate())
                .post(comment.getPost().getId())
                .build();
    }

}
