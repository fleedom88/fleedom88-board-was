package com.fleedom88.boardback.common;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import java.util.Arrays;

public enum GymCode {
    SEOUL("6110000", "서울특별시",
    new District("3000000","종로구"),
    new District("3010000","중구"),
    new District("3020000","용산구"),
    new District("3030000","성동구"),
    new District("3040000","광진구"),
    new District("3050000","동대문구"),
    new District("3060000","중랑구"),
    new District("3070000","성북구"),
    new District("3080000","강북구"),
    new District("3090000","도봉구"),
    new District("3100000","노원구"),
    new District("3110000","은평구"),
    new District("3120000","서대문구"),
    new District("3130000","마포구"),
    new District("3140000","양천구"),
    new District("3150000","강서구"),
    new District("3160000","구로구"),
    new District("3170000","금천구"),
    new District("3180000","영등포구"),
    new District("3190000","동작구"),
    new District("3200000","관악구"),
    new District("3210000","서초구"),
    new District("3220000","강남구"),
    new District("3230000","송파구"),
    new District("3240000","강동구")
    ),
    BUSAN("6260000", "부산광역시",
    new District("3250000","중구"),
    new District("3260000","서구"),
    new District("3270000","동구"),
    new District("3280000","영도구"),
    new District("3290000","부산진구"),
    new District("3300000","동래구"),
    new District("3310000","남구"),
    new District("3320000","북구"),
    new District("3330000","해운대구"),
    new District("3340000","사하구"),
    new District("3350000","금정구"),
    new District("3360000","강서구"),
    new District("3370000","연제구"),
    new District("3380000","수영구"),
    new District("3390000","사상구"),
    new District("3400000","기장군")
    );
    


    private final String code;
    private final String name;
    private final List<District> districts;

    private static final Map<String, District> districtMap = new HashMap<>();

    GymCode(String code, String name, District... districts) {
        this.code = code;
        this.name = name;
        this.districts = Arrays.asList(districts);
        for (District district : this.districts) {
            district.setRegion(this);
        }
    }

    static {
        for (GymCode region : values()) {
            for (District district : region.getDistricts()) {
                districtMap.put(district.getCode(), district);
            }
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public static District findDistrictByCode(String districtCode) {
        return districtMap.get(districtCode);
    }

    public static GymCode findRegionByDistrictCode(String districtCode) {
        District district = findDistrictByCode(districtCode);
        return district != null ? district.getRegion() : null;
    }

    public static class District {
        private final String code;
        private final String name;
        private GymCode region;

        public District(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        void setRegion(GymCode region) {
            this.region = region;
        }

        public GymCode getRegion() {
            return region;
        }
    }
}