package com.app.restaurante.model;
import jakarta.persistence.*;

@Entity
@Table(name = "detallecliente")
public class DetalleCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleCliente;

    @Column(length = 9, nullable = true)
    private String telefono;

    @Column(length = 100, nullable = true)
    private String correo;

    @Column(length = 100, nullable = true)
    private String foto;

    @ManyToOne
    @JoinColumn(name = "IDCliente")
    private Cliente cliente;

    // Getters y Setters
}
