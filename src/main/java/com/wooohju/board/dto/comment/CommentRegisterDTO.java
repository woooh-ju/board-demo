package com.wooohju.board.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CommentRegisterDTO {
    @Size(max=200)
    @NotBlank
    String content;
}
