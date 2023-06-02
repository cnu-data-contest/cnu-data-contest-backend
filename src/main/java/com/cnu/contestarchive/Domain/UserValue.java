package com.cnu.contestarchive.Domain;

import lombok.Getter;

@Getter
public class UserValue {

    String isMember;
    String name;
    String major;

    public UserValue(String isMember) {
        this.isMember = isMember;
    }

    public UserValue(String isMember, String name, String major) {
        this.isMember = isMember;
        this.name = name;
        this.major = major;
    }
}
