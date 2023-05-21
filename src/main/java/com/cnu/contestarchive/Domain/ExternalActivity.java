package com.cnu.contestarchive.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExternalActivity {

    @Id
    private String title;

    private String user_id;

    private String section;

}
