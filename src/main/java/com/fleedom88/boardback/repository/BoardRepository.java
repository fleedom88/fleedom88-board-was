package com.fleedom88.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fleedom88.boardback.entity.BoardEntity;
import com.fleedom88.boardback.repository.resultSet.GetBoardResultSet;

public interface BoardRepository extends JpaRepository<BoardEntity,String>{
    
    boolean existsByBoardNumber(Integer boardNumber);

    BoardEntity findByBoardNumber(Integer boardNumber);

    @Query(
        value=
        """
        SELECT 
            B.board_number AS boardNumber,
            B.title AS title,
            B.content AS content,
            B.write_datetime AS writeDatetime,
            B.writer_email AS writerEmail,
            U.nickname AS writerNickname,
            U.profile_image AS writerProfileImage
        FROM board AS B
            INNER JOIN user AS U
            ON B.writer_email = U.email
        WHERE board_number  = ?1
        """,
        nativeQuery=true
    )
    GetBoardResultSet getBoard(Integer boardNumber);

}
