package com.cnu.contestarchive.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    String userId;
    String userPw;
    String major;

    @Builder
    public UserRequestDto(String id, String password) {
        this.userId = id;
        this.userPw = password;
    }


}
