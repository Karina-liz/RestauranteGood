package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "intentos")
public class Intentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIntentos;

    private Integer fallos;
    private Integer ingresos;

    @ManyToOne
    @JoinColumn(name = "IDCliente")
    private Cliente cliente;

    // Getters y Setters
}
