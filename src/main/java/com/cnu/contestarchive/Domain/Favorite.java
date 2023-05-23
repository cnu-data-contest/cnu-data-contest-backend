package com.cnu.contestarchive.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  // 데이터베이스의 테이블과 매핑
public class Favorite {

    @Id  // 테이블의 기본 키(primary key)
    private String Id;

    private String section;

    private String title;

    public Favorite() {

    }

    public Favorite(String id, String section, String title) {
        this.Id = id;
        this.section = section;
        this.title = title;
    }
    public String getId() {
        return Id;
    }
    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
