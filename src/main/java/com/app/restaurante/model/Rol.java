package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name = "NomRol", length = 50)
    private String nomRol;

    @Column(name = "Descripcion", length = 100)
    private String descripcion;

    // Getters y Setters
}

