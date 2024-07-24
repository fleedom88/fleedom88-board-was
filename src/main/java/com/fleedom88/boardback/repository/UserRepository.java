package com.fleedom88.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fleedom88.boardback.entity.UserEntity;

@Repository                                             //entity, primary key의 type
public interface UserRepository extends JpaRepository<UserEntity, String>{

    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByTelNumber(String telNumber);        

    UserEntity findByEmail(String email); //규칙적으로 작성하면 JPA가 자동으로 셀렉트해줌
}
