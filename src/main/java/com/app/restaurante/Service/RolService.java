package com.app.restaurante.Service;

import com.app.restaurante.model.Rol;
import com.app.restaurante.dao.RolDAO; // Asegúrate de tener un DAO para los roles
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolDAO rolDAO;

    public List<Rol> findAll() {
        return rolDAO.findAll();
    }
}
