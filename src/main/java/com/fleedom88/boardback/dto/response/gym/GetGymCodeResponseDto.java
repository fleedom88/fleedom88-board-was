package com.fleedom88.boardback.dto.response.gym;

import com.fleedom88.boardback.common.ResponseCode;
import com.fleedom88.boardback.common.ResponseMessage;
import com.fleedom88.boardback.dto.response.ResponseDto;
import com.fleedom88.boardback.repository.resultSet.GetGymResultSet;

import lombok.Getter;

@Getter
public class GetGymCodeResponseDto extends ResponseDto {
    
    private GetGymCodeResponseDto(GetGymResultSet resultSet){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }
}
