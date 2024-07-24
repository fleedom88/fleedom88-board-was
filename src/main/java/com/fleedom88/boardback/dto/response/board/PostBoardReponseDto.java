package com.fleedom88.boardback.dto.response.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fleedom88.boardback.common.ResponseCode;
import com.fleedom88.boardback.common.ResponseMessage;
import com.fleedom88.boardback.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class PostBoardReponseDto extends ResponseDto {
    
    private PostBoardReponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PostBoardReponseDto> success() {
        PostBoardReponseDto result = new PostBoardReponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistedUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }

}
