package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDistrito;

    @Column(length = 50, nullable = true)
    private String distrito;

    // Getters y Setters
}
