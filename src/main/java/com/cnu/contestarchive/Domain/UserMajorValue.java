package com.cnu.contestarchive.Domain;

import lombok.Getter;

@Getter
public class UserMajorValue {
    String major;

    public UserMajorValue(String major) {
        this.major = major;
    }
}
