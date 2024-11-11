package com.app.restaurante.model;
import jakarta.persistence.*;
public class DetalleCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleCliente;

    private String telefono;
    private String correo;
    private String foto;

    @ManyToOne
    @JoinColumn(name = "IDCliente")
    private Cliente cliente;

    // Getters y Setters
}
