package com.fleedom88.boardback.entity;

import com.fleedom88.boardback.entity.primaryKey.FavoritePk;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="favorite")
@Table(name="favorite")
@IdClass(FavoritePk.class) // 복합키 표시 할 수 있게함
public class FavoriteEntity {
    @Id
    private String userEmail;
    @Id
    private int boardNumber;

}
