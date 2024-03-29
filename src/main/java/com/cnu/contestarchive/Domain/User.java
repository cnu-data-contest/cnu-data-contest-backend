package com.cnu.contestarchive.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User {

    @Id
    private String id;

    private String password;

    private String name;

    private String major;

    private String favoriteMajor;

}
