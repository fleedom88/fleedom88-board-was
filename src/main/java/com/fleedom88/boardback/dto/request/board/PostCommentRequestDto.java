package com.fleedom88.boardback.dto.request.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCommentRequestDto {

    @NotBlank //int boolean에서 사용 불가
    private String content;
    
}
