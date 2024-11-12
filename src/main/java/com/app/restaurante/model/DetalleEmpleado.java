package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleempleado")
public class DetalleEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleEmp;

    @Column(length = 9, nullable = true)
    private String telefono;

    @Column(length = 100, nullable = true)
    private String correo;

    @Column(length = 150, nullable = true)
    private String foto;

    @OneToOne
    @JoinColumn(name = "IDEmpleado")
    private Empleado empleado;

    // Getters y Setters
}
