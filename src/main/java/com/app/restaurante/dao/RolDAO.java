package com.app.restaurante.dao;

import com.app.restaurante.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDAO extends JpaRepository<Rol, Integer> {
}
