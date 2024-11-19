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

/**
 * Controlador para gestionar las operaciones relacionadas con los productos
 */
@Controller
public class ProductoController {

    @Autowired
    private ProductosDAO productosDAO;

    /**
     * Método que maneja la solicitud GET para mostrar la carta de productos
     * Obtiene los productos por categoría y establece una imagen por defecto si no tienen una asignada
     * @param model Modelo para pasar datos a la vista
     * @return Vista 'carta' con los productos organizados por categoría
     */
    @GetMapping("/carta")
    public String mostrarCarta(Model model) {
        // Obtiene los productos separados por categorías
        List<Productos> bebidas = productosDAO.obtenerPorCategoria("Bebidas");
        List<Productos> postres = productosDAO.obtenerPorCategoria("Postres");
        List<Productos> platillos = productosDAO.obtenerPorCategoria("Platillos");
    
        // Asigna imagen por defecto a bebidas si no tienen una
        for (Productos producto : bebidas) {
            if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
                producto.setFotoProducto("default");
            }
        }
        
        // Asigna imagen por defecto a postres si no tienen una
        for (Productos producto : postres) {
            if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
                producto.setFotoProducto("default");
            }
        }
        
        // Asigna imagen por defecto a platillos si no tienen una
        for (Productos producto : platillos) {
            if (producto.getFotoProducto() == null || producto.getFotoProducto().isEmpty()) {
                producto.setFotoProducto("default");
            }            
        }
        
        // Agrega las listas de productos y la página activa al modelo
        model.addAttribute("bebidas", bebidas);
        model.addAttribute("postres", postres);
        model.addAttribute("platillos", platillos);
        model.addAttribute("activePage", "carta");
    
        return "carta";
    }

    /**
     * Método que maneja la solicitud GET para obtener los detalles de un producto específico
     * @param idProducto ID del producto a consultar
     * @param model Modelo para pasar datos a la vista
     * @return Vista 'modalproducto' con los detalles del producto
     */
    @GetMapping("/producto/{idProducto}")
    public String obtenerDetalleProducto(@PathVariable("idProducto") int idProducto, Model model) {
        Productos producto = productosDAO.obtenerProductoPorId(idProducto);
        model.addAttribute("producto", producto);
        return "modalproducto";
    }
}
