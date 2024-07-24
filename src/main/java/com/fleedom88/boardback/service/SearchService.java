package com.fleedom88.boardback.service;

import org.springframework.http.ResponseEntity;

import com.fleedom88.boardback.dto.response.search.GetPopularListResponseDto;
import com.fleedom88.boardback.dto.response.search.GetRelationListResponseDto;

public interface SearchService {

    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
    ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord);
    
}
