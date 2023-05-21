package com.cnu.contestarchive.Domain;

import lombok.Getter;

@Getter
public class UserValue {

    boolean isMember;

    public UserValue(boolean isMember) {
        this.isMember = isMember;
    }
}
