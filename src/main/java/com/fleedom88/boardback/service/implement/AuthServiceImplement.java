package com.fleedom88.boardback.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fleedom88.boardback.dto.request.auth.SignInRequestDto;
import com.fleedom88.boardback.dto.request.auth.SignUpRequestDto;
import com.fleedom88.boardback.dto.response.ResponseDto;
import com.fleedom88.boardback.dto.response.auth.SignInResponseDto;
import com.fleedom88.boardback.dto.response.auth.SignUpResponseDto;
import com.fleedom88.boardback.entity.UserEntity;
import com.fleedom88.boardback.provider.JwtProvider;
import com.fleedom88.boardback.repository.UserRepository;
import com.fleedom88.boardback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor// final 붙은 필드에 대해서 자동으로 생성자, 세터 만들어준다
public class AuthServiceImplement implements AuthService { // 구현체

    
    // @Autowired // bean에 등록되어있는 것들이 자동으로 주입됨, (필드)     @Repository bean에 등록됨
    // private UserRepository userRepository; 

    // @Autowired
    // public AuthServiceImplement(UserRepository userRepository){//생성자, 레포지토리가 빈 상황이 발생하지 않아서 가장 선호됨
    //     this.userRepository = userRepository;
    // }
    
    // @Autowired
    // public void setUserRepository(UserRepository userRepository){//(세터)
        //     this.userRepository = userRepository;
        // }
    
            
    private final UserRepository userRepository; 
    private final JwtProvider  jwtProvider;
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        
        try {

            String email = dto.getEmail();
            boolean existedEmail = userRepository.existsByEmail(email);
            if(existedEmail) return SignUpResponseDto.duplicateEmail();
             
            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if(existedNickname) return SignUpResponseDto.duplicateNickname();

            String telNumber = dto.getTelNumber();
            boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
            if(existedTelNumber) return SignUpResponseDto.duplicateTelNumber();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);
            
            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
       
        String token = null;
               
        try {
            
            String email = dto.getEmail();
            UserEntity userEntity = userRepository.findByEmail(email);
            if (userEntity == null) {
                return SignInResponseDto.signInFailed();
            }

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if(isMatched == false){
                return SignInResponseDto.signInFailed();
            }

            token = jwtProvider.create(email);//이메일로 토큰 만듦

       } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
       }

       return SignInResponseDto.success(token);
    }
    
}
