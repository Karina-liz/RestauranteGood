package com.app.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.restaurante.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

}
