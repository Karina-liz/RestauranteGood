package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalleempleado")
public class DetalleEmpleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleEmp;

    @Column(name = "Telefono", length = 9)
    private String telefono;

    @Column(name = "Correo", length = 100)
    private String correo;

    @Column(name = "Foto", length = 150)
    private String foto;

    @OneToOne
    @JoinColumn(name = "IDEmpleado")
    private Empleado empleado;

    // Getters y Setters
}
