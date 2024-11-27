package com.app.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.restaurante.model.Cliente;

import jakarta.servlet.http.HttpSession;

// Es una logica simple para pagar y empezar el delivery
@Controller
public class PagoController {

    @Autowired
    private HttpSession session;

    // Método para manejar el pago
    @PostMapping("/guardarPago")
    public String procesarPago(@RequestParam("idPedido") Long idPedido, 
                               @RequestParam("total") Double total, 
                               RedirectAttributes redirectAttributes) {

        // Obtener el idCliente de la sesión
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login";
        }

        if (idPedido == null || total == null || total <= 0) {
            redirectAttributes.addFlashAttribute("error", "Datos de pago inválidos.");
            return "redirect:/carrito_compra";
        }

        // Envio de datos a la consulta
        


        redirectAttributes.addFlashAttribute("mensaje", "Pago procesado exitosamente.");
        return "redirect:/confirmacion";
    }


}
