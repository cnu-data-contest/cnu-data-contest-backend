package com.cnu.contestarchive.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity  // 데이터베이스의 테이블과 매핑
public class Favorite {

    @Id  // 테이블의 기본 키(primary key)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String section;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
