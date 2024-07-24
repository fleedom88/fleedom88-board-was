package com.fleedom88.boardback.service;

import org.springframework.http.ResponseEntity;

import com.fleedom88.boardback.dto.request.board.PatchBoardRequestDto;
import com.fleedom88.boardback.dto.request.board.PostBoardRequestDto;
import com.fleedom88.boardback.dto.request.board.PostCommentRequestDto;
import com.fleedom88.boardback.dto.response.board.GetBoardResponseDto;
import com.fleedom88.boardback.dto.response.board.GetFavoriteListResponseDto;
import com.fleedom88.boardback.dto.response.board.GetLatestBoardListResponseDto;
import com.fleedom88.boardback.dto.response.board.GetTop3BoardListResponseDto;
import com.fleedom88.boardback.dto.response.board.GetSearchBoardListResponseDto;
import com.fleedom88.boardback.dto.response.board.GetUserBoardListResponseDto;
import com.fleedom88.boardback.dto.response.board.GetCommentListResponseDto;
import com.fleedom88.boardback.dto.response.board.PostBoardReponseDto;
import com.fleedom88.boardback.dto.response.board.PostCommentResponseDto;
import com.fleedom88.boardback.dto.response.board.PutFavoriteResponseDto;
import com.fleedom88.boardback.dto.response.board.PatchBoardResponseDto;
import com.fleedom88.boardback.dto.response.board.IncreaseViewCountResponseDto;
import com.fleedom88.boardback.dto.response.board.DeleteBoardResponseDto;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
    ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList();
    ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList();
    ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord, String preSearchWord);
    ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(String email);
    ResponseEntity<? super PostBoardReponseDto> postBoard(PostBoardRequestDto dto, String email);
    ResponseEntity<? super PostCommentResponseDto> PostComment(PostCommentRequestDto dto, Integer boardNumber ,String email);
    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email) ;
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber, String email);
    ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);
    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);
}
