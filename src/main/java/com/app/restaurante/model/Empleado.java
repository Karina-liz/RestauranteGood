package com.app.restaurante.model;
import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    @Column(length = 50, nullable = true)
    private String nombre;

    @Column(length = 50, nullable = true)
    private String apellido;

    @Column(length = 50, nullable = true)
    private String usuario;

    @Column(length = 150, nullable = true)
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "IDRol")
    private Rol rol;

    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
    private DetalleEmpleado detalleEmpleado;

    // Getters y Setters
    public DetalleEmpleado getDetalleEmpleado() {
        return detalleEmpleado;
    }

    public void setDetalleEmpleado(DetalleEmpleado detalleEmpleado) {
        this.detalleEmpleado = detalleEmpleado;
        detalleEmpleado.setEmpleado(this); // Relación bidireccional
    }


    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    //constructor vacio
    public Empleado() {
    }

    public Empleado(Integer idEmpleado, String nombre, String apellido, String usuario,
            String contraseña, Rol rol) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    
    @Override
    public String toString() {
        return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido =" + apellido + ", usuario=" + usuario + ", contraseña=" + contraseña + ", rol=" + rol +"]"; }
}


