package com.app.restaurante.controller;

import com.app.restaurante.dao.ProductosDAO;
import com.app.restaurante.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    
        for (Productos producto : bebidas) {
            //System.out.println("Antes de asignar default, FotoProducto: " + producto.getFotoProducto());
            if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
                producto.setFotoProducto("default");
            }
            //System.out.println("Después de asignar default, FotoProducto: " + producto.getFotoProducto());
        }
        
        
        for (Productos producto : postres) {
            //System.out.println("Antes de asignar default, FotoProducto: " + producto.getFotoProducto());
            if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
                producto.setFotoProducto("default");
            }
            //System.out.println("Después de asignar default, FotoProducto: " + producto.getFotoProducto());
        }
        
        for (Productos producto : platillos) {
            if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
                producto.setFotoProducto("default");
            }            
        }
        
    
        model.addAttribute("bebidas", bebidas);
        model.addAttribute("postres", postres);
        model.addAttribute("platillos", platillos);
        model.addAttribute("activePage", "carta");

                // Verifica el contenido de los productos antes de retornarlos

    
        return "carta";
    }


    @GetMapping("/producto/{idProducto}")
    public String obtenerDetalleProducto(@PathVariable("idProducto") int idProducto, Model model) {
        Productos producto = productosDAO.obtenerProductoPorId(idProducto);
        model.addAttribute("producto", producto);
        return "modalproducto"; // nombre de la página HTML de detalles
    }

    
}
