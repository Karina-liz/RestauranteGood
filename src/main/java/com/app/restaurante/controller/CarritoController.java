package com.app.restaurante.controller;

import com.app.restaurante.dao.ProductosDAO;
import com.app.restaurante.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con el carrito de compras
 */
@Controller
public class CarritoController {

    @Autowired
    private ProductosDAO productosDAO;

    private List<Productos> carrito = new ArrayList<>();

    /**
     * Método que maneja la solicitud GET para mostrar el carrito de compras
     * @param model Modelo para pasar datos a la vista
     * @return Vista 'carrito' con los productos en el carrito
     */
    @GetMapping("/carrito")
    public String mostrarCarrito(Model model) {
        model.addAttribute("carrito", carrito);
        return "carrito";
    }

    /**
     * Método que maneja la solicitud POST para agregar un producto al carrito
     * @param idProducto ID del producto a agregar
     * @return Redirige a la vista del carrito
     */
    @PostMapping("/carrito/agregar")
    public String agregarProductoAlCarrito(@RequestParam("idProducto") int idProducto) {
        Productos producto = productosDAO.obtenerProductoPorId(idProducto);
        if (producto != null) {
            carrito.add(producto);
        }
        return "redirect:/carrito";
    }
}