package com.app.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.restaurante.dao.ProductosDAO;
import com.app.restaurante.model.Productos;
import com.app.restaurante.service.UploadServicio;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ProductAdminController {
    @Autowired
    private ProductosDAO productosDAO;
    @Autowired
    private UploadServicio uploadServicio;

    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        List<Productos> productos = productosDAO.findAll(); // Obtener la lista de productos
        model.addAttribute("productos", productos); // Agregar la lista al modelo
        
        return "listProductos"; // Nombre de la vista que se mostrará
    
    }

    @GetMapping("/productos/nuevo")
    public String nuevoProductoForm(Model model) {
        model.addAttribute("producto", new Productos()); // Crear un producto vacío
        return "formProducto"; // Nombre de la vista del formulario
    }

    @PostMapping("/productos")
    public String guardarProducto(@ModelAttribute Productos producto, @RequestParam("file") MultipartFile file) {
        try {
            String fileName = uploadServicio.saveUpload(file, "productos"); // Guardar en subcarpeta "productos"
            if (fileName != null) {
                producto.setFotoProducto(fileName); // Asignar nombre del archivo al producto
                
            }
            productosDAO.save(producto); // Guardar el producto en la base de datos

            } catch (IOException e) {
        e.printStackTrace();
        return "error";
    }
    if (producto.getFechaProducto() == null || producto.getFechaProducto().isEmpty()) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        producto.setFechaProducto(LocalDateTime.now().format(formatter));
    }
        
        return "redirect:/productos"; // Redirigir a la lista de productos
}
}
