package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(length = 50, nullable = true)
    private String nombre;

    @Column(length = 50, nullable = true)
    private String apellido;

    @Column(length = 50, nullable = true)
    private String usuario;

    @Column(length = 350, nullable = true)
    private String contraseña;

    @Column(length = 8, nullable = true)
    private String dni;

    // Getters y Setters
}
