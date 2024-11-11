package com.app.restaurante.model;
import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    @Column(name = "Nombre", length = 50)
    private String nombre;

    @Column(name = "ApellidoPaterno", length = 50)
    private String apellidoPaterno;

    @Column(name = "ApellidoMaterno", length = 50)
    private String apellidoMaterno;

    @Column(name = "Usuario", length = 50)
    private String usuario;

    @Column(name = "Contraseña", length = 150)
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "IDRol")
    private Rol rol;

    // Getters y Setters
}


