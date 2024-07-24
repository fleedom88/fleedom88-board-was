package com.fleedom88.boardback.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fleedom88.boardback.common.ResponseCode;
import com.fleedom88.boardback.common.ResponseMessage;
import com.fleedom88.boardback.dto.object.FavoriteListitem;
import com.fleedom88.boardback.dto.response.ResponseDto;
import com.fleedom88.boardback.repository.resultSet.GetFavoriteListResultSet;

import lombok.Getter;

@Getter
public class GetFavoriteListResponseDto extends ResponseDto {
    
    private List<FavoriteListitem> favoriteList;

    private GetFavoriteListResponseDto(List<GetFavoriteListResultSet> resultSets ) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.favoriteList = FavoriteListitem.copyList(resultSets);
    }

    public static ResponseEntity<GetFavoriteListResponseDto> succcess(List<GetFavoriteListResultSet> resultSets) {
        GetFavoriteListResponseDto result = new GetFavoriteListResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

}
