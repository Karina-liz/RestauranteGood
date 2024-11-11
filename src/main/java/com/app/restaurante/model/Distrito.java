package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDistrito;

    private String distrito;

    // Getters y Setters
}
