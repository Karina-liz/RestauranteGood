package com.app.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.app.restaurante.dao.ProductosDAO;
import com.app.restaurante.model.Productos;

import java.util.List;

@Controller
public class ProductAdminController {
    @Autowired
    private ProductosDAO productosDAO;

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        List<Productos> productos = productosDAO.findAll(); // Obtener la lista de productos
        model.addAttribute("productos", productos); // Agregar la lista al modelo
        return "listProductos"; // Nombre de la vista que se mostrará
    }
}
