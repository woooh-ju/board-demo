package com.wooohju.board.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wooohju.board.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class PostResponseDTO {
    Long id;
    String title;
    String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("create_date")
    LocalDate createDate;

    public static PostResponseDTO from(Post post)
    {
        return PostResponseDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createDate(post.getCreateDate())
                .build();
    }
}
