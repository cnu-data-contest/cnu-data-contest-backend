package com.cnu.contestarchive.Dto;

import com.cnu.contestarchive.Domain.Favorite;
import com.cnu.contestarchive.Domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FavoriteRequestDto {

    private String userId;
    private String section;
    private String title;

    @Builder
    public FavoriteRequestDto(String userId, String section, String title) {
        this.userId = userId;
        this.section = section;
        this.title = title;
    }
}
