package com.fleedom88.boardback.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.fleedom88.boardback.repository.resultSet.GetFavoriteListResultSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteListitem {
    private String email;
    private String nickname;
    private String profileImage;

    public FavoriteListitem(GetFavoriteListResultSet resultSet){
        this.email = resultSet.getEmail();
        this.nickname = resultSet.getNickname();
        this.profileImage = resultSet.getProfileIamge();
    }

    public static List<FavoriteListitem> copyList(List<GetFavoriteListResultSet> resultSets) {
        List<FavoriteListitem> list = new ArrayList<>();
        for(GetFavoriteListResultSet resultSet: resultSets) {
            FavoriteListitem favoriteListitem = new FavoriteListitem(resultSet);
            list.add(favoriteListitem);           
        }
        return list;
    }
}
