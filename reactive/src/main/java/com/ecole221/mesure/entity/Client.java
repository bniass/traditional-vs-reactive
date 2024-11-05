package com.ecole221.mesure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Client {
    @Id
    private long id;
    private String prenom;
    private String nom;
    private String email;
}
