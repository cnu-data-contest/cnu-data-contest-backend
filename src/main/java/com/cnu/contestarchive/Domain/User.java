package com.cnu.contestarchive.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "externalActivity")
    private List<ExternalActivity> externalActivities = new ArrayList<>();
}
