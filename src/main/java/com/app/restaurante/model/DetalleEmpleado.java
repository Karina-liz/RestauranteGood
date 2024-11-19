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

    public Integer getIdDetalleEmp() {
        return idDetalleEmp;
    }

    public void setIdDetalleEmp(Integer idDetalleEmp) {
        this.idDetalleEmp = idDetalleEmp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public DetalleEmpleado() {
    }

    public DetalleEmpleado(Integer idDetalleEmp, String telefono, String correo, String foto, Empleado empleado) {
        this.idDetalleEmp = idDetalleEmp;
        this.telefono = telefono;
        this.correo = correo;
        this.foto = foto;
        this.empleado = empleado;
    }

    // Getters y Setters
    
}
