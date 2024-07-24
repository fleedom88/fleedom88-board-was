package com.fleedom88.boardback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "search_log")
@Table(name = "search_log")
public class SearchLogEntity { //클래스명 SearchLog만 적어도 알아서 찾아감
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sequence;
    private String searchWord;
    private String relationWord;
    private boolean relation;

    public SearchLogEntity(String searchWord, String relationWord,  boolean relation) {
        this.searchWord = searchWord;
        this.relationWord = relationWord;
        this.relation = relation;
    }
    
}
