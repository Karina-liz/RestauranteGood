package com.app.restaurante.service;

import com.app.restaurante.model.Rol;
import com.app.restaurante.repository.RolRepository; // Asegúrate de tener un repository para los roles
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }
}
