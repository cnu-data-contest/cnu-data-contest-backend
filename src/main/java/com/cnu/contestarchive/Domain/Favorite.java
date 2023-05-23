package com.cnu.contestarchive.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  // 데이터베이스의 테이블과 매핑
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Favorite {

    @Id  // 테이블의 기본 키(primary key)
    private String Id;

    private String section;

    private String title;
}
