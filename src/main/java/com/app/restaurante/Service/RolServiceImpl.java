package com.app.restaurante.service;

import com.app.restaurante.model.Empleado;
import com.app.restaurante.model.Rol;
import com.app.restaurante.repository.RolRepository; // Asegúrate de tener un repository para los roles
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolServiceImpl {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Rol guardarRol(Rol rol){
        return rolRepository.save(rol);
    }

    public Rol obtenerRolPorId(Integer id){
        return rolRepository.findById(id).orElse(null);
    }

    public void eliminarRol(Integer id) {
        rolRepository.deleteById(id);
    }
}
