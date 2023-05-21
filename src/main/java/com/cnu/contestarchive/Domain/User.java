package com.cnu.contestarchive.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    private String major;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<ExternalActivity> externalActivities = new ArrayList<>();
}
