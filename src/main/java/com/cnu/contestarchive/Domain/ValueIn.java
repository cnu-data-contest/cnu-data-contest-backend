package com.cnu.contestarchive.Domain;


import lombok.Getter;

@Getter
public class ValueIn {
    String title;
    String content;
    String image;

    public ValueIn(String title, String content, String image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }
}
