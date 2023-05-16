package com.cnu.contestarchive.Domain;


import lombok.Getter;

@Getter
public class ValueIn {
    String title;
    String content;
    String image;
    String baseUrl;

    public ValueIn(String title, String content, String image, String baseUrl) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.baseUrl = baseUrl;
    }
}
