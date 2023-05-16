package com.cnu.contestarchive.Domain;

import lombok.Getter;

@Getter
public class MoreValue {
    String title;
    String content;
    String image;
    String baseUrl;
    String writer;
    String update_dt;

    public MoreValue(String title, String content, String image, String baseUrl, String writer, String update_dt) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.baseUrl = baseUrl;
        this.writer = writer;
        this.update_dt = update_dt;
    }
}
