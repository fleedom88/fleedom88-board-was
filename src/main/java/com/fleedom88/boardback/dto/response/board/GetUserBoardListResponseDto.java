package com.fleedom88.boardback.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fleedom88.boardback.common.ResponseCode;
import com.fleedom88.boardback.common.ResponseMessage;
import com.fleedom88.boardback.dto.object.BoardListItem;
import com.fleedom88.boardback.dto.response.ResponseDto;
import com.fleedom88.boardback.entity.BoardListViewEntity;

import lombok.Getter;

@Getter
public class GetUserBoardListResponseDto extends ResponseDto{
    private List<BoardListItem> userBoardList;

    private GetUserBoardListResponseDto(List<BoardListViewEntity> boardListItemsEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userBoardList = BoardListItem.getList(boardListItemsEntities);
    }

    public static ResponseEntity<GetUserBoardListResponseDto> success(List<BoardListViewEntity> boardListViewEntities){
        GetUserBoardListResponseDto result = new GetUserBoardListResponseDto(boardListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}

