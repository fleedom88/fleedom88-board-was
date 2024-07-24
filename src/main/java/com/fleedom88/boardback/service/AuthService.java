package com.fleedom88.boardback.service;

import org.springframework.http.ResponseEntity;

import com.fleedom88.boardback.dto.request.auth.SignInRequestDto;
import com.fleedom88.boardback.dto.request.auth.SignUpRequestDto;
import com.fleedom88.boardback.dto.response.auth.SignInResponseDto;
import com.fleedom88.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    //ResponseEntity타입을 SignInResponseDto 형태로 반환해주고 이것의 부모형태는 다 받겠다(super)
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto); 
}
