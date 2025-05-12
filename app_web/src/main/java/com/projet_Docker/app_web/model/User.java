package com.projet_Docker.app_web.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    // Constructeur sans argument pour JPA
    public User() {}

    // Constructeur avec paramètres (facultatif)
    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

}
