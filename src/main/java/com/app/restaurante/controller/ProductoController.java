package com.app.restaurante.controller;

import com.app.restaurante.dao.ProductosDAO;
import com.app.restaurante.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductoController {

    @Autowired
    private ProductosDAO productosDAO;

    
    @GetMapping("/carta")
    public String mostrarCarta(Model model) {
        List<Productos> bebidas = productosDAO.obtenerPorCategoria("Bebidas");
        List<Productos> postres = productosDAO.obtenerPorCategoria("Postres");
        List<Productos> platillos = productosDAO.obtenerPorCategoria("Platillos");
    
        // Verifica los productos para ver si la propiedad FotoProducto está llegando
        for (Productos producto : bebidas) {
            if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
                producto.setFotoProducto("default.jpg");
            }
        }
        
        for (Productos producto : postres) {
            if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
                producto.setFotoProducto("default.jpg");
            }
        }
        
        for (Productos producto : platillos) {
            if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
                producto.setFotoProducto("default.jpg");
            }
        }
        
    
        model.addAttribute("bebidas", bebidas);
        model.addAttribute("postres", postres);
        model.addAttribute("platillos", platillos);
        model.addAttribute("activePage", "carta");
    
        return "carta";
    }
    
    
}
