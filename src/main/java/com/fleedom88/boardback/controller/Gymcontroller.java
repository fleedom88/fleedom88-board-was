package com.fleedom88.boardback.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleedom88.boardback.common.constraints.KoreaAdministrativeDivision;

@RestController
@RequestMapping("/gym")
public class Gymcontroller {
    
    @PostMapping(value = "{districtCode}")
    public String getInfo(
        @PathVariable("districtCode") String districtCode
    ){
        KoreaAdministrativeDivision.AdministrativeInfo info = KoreaAdministrativeDivision.getAdministrativeInfoByDistrictCode(districtCode);
        return info.getSidoName();
    }

}
