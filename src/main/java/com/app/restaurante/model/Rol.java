package com.app.restaurante.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name = "NomRol", length = 50)
    private String nomRol;

    @Column(name = "Descripcion", length = 100)
    private String descripcion;

    //get y set

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //constructor vacio

    public Rol() {
    }

    public Rol(Integer idRol, String nomRol, String descripcion) {
        this.idRol = idRol;
        this.nomRol = nomRol;
        this.descripcion = descripcion;
    }

    
}

