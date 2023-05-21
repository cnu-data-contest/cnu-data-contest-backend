package com.cnu.contestarchive.Domain;

import lombok.Getter;

@Getter
public class UserValue {

    String isMember;

    public UserValue(String isMember) {
        this.isMember = isMember;
    }
}
