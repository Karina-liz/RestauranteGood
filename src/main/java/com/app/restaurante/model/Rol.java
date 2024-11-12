package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(length = 50, nullable = true)
    private String nomRol;

    @Column(length = 100, nullable = true)
    private String descripcion;

    // Getters y Setters
}

