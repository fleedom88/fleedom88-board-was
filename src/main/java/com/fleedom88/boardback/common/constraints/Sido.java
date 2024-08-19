package com.fleedom88.boardback.common.constraints;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Sido {
    SEOUL("6110000", "서울특별시"),
    BUSAN("6260000", "부산광역시"),
    DAEGU("6260000", "대구광역시"),
    INCHEON("6280000", "인천광역시"),
    GWANGJU("6290000", "광주광역시"),
    DAEJEON("6300000", "대전광역시"),
    ULSAN("6310000", "울산광역시"),
    SEJONG("5690000", "세종특별자치시"),
    GYEONGGI("6410000", "경기도"),
    CHUNGCHEONGBUK("6430000", "충청북도"),
    CHUNGCHEONGNAM("6440000", "충청남도"),
    JEOLLABUK("6540000", "전북특별자치도"),
    JEOLLANAM("6460000", "전라남도"),
    GYEONGSANBUK("6470000", "경상북도"),
    JEJU("6500000", "제주특별자치도");
   
    private final String code;
    private final String name;

    public String getCode(){
        return code;
    }
    
    public String getName(){
        return name;
    }

    public static Sido getByCode(String code) {
        for (Sido sido : values()) {
            if (sido.getCode().equals(code)) {
                return sido;
            }
        }
        return null;
    }
}