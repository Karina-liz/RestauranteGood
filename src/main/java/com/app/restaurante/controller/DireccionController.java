package com.app.restaurante.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.restaurante.dao.ClienteDAO;
import com.app.restaurante.model.Cliente;
import jakarta.servlet.http.HttpSession;

@Controller
public class DireccionController {

    @Autowired
    private ClienteDAO clienteDAO;

    @Autowired
    private HttpSession session;

    @PostMapping("/guardarDireccion")
    public String guardarDireccion(@RequestParam("direccion") String direccion,
                                   @RequestParam("ciudad") String ciudad,
                                   RedirectAttributes redirectAttributes,
                                   @SessionAttribute("cliente") Cliente cliente) {
        if (cliente == null) {
            return "redirect:/login";
        }
    
        clienteDAO.saveDireccion(cliente.getIdCliente(), direccion, ciudad);
    
        redirectAttributes.addFlashAttribute("success", "Dirección registrada exitosamente");
        return "redirect:/registro_completar";
    }

    // Mostramos los distritos
    @GetMapping("/obtenerDistritos")
    public List<String> obtenerDistritos() {
        List<String> distritos = new ArrayList<>();
        // Agregar distritos según sea necesario
        distritos.add("Distrito 1");
        distritos.add("Distrito 2");
        distritos.add("Distrito 3");
        return distritos;
    }
    

}
