package com.wooohju.board.dto.post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class PostRegisterDTO
{
    @NotBlank
    @Size(max=30)
    String title;

    @NotBlank
    String content;
}
