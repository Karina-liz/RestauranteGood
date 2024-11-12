package com.app.restaurante.dao;

import com.app.restaurante.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoDAO extends JpaRepository<Empleado, Integer> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
