package com.app.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.restaurante.dao.PagoDAO;
import com.app.restaurante.model.Cliente;

import jakarta.servlet.http.HttpSession;

// Esta es una lógica simple para manejar el pago y comenzar el delivery
@Controller
public class PagoController {

    @Autowired
    private HttpSession session;

    @Autowired
    private PagoDAO pagoDAO;

    
    @PostMapping("/guardarPago")
    public String procesarPago(@RequestParam("idPedido") Long idPedido, 
                           @RequestParam("montoTotal") Double total, 
                           @RequestParam("nombreTitular") String nombreTitular,
                           @RequestParam("numeroTarjeta") String numeroTarjeta,
                           @RequestParam("fechaVencimiento") String fechaVencimiento,
                           @RequestParam("codigoSeguridad") String codigoSeguridad,
                           RedirectAttributes redirectAttributes) {
    
        // Obtener el cliente de la sesión
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            return "redirect:/login";
        }

       // Validar los datos de pago
        if (idPedido == null || total == null || total <= 0 || 
           nombreTitular == null || numeroTarjeta == null || 
           fechaVencimiento == null || codigoSeguridad == null) {
           redirectAttributes.addFlashAttribute("error", "Datos de pago inválidos.");
           return "redirect:/carrito_compra";
        }


        // Validar los datos de la tarjeta usando PagoDAO
        if (!validarDatosTarjeta(numeroTarjeta, fechaVencimiento, codigoSeguridad, nombreTitular)) {
            redirectAttributes.addFlashAttribute("error", "Datos de tarjeta inválidos.");
            return "redirect:/carrito_compra";
        }

        // Registrar el pago si los datos son correctos
        pagoDAO.registrarPago(idPedido, total); // Asegúrate de que este método exista en PagoDAO

        // Actualizar el estado del pedido a "pagado"
        pagoDAO.actualizarEstadoPedido(idPedido, "Pagado"); // Asegúrate de que este método exista en PagoDAO

        redirectAttributes.addFlashAttribute("mensaje", "Pago procesado exitosamente.");

        
        
        return "redirect:/carrito_compra";
    }   


    // Método para validar los datos de la tarjeta usando PagoDAO
    private boolean validarDatosTarjeta(String numeroTarjeta, String fechaVencimiento, String codigoSeguridad, String nombreTitular) {
        // Aquí deberías incluir la lógica para consultar el PagoDAO
        // Retornar true si la tarjeta es válida, false si no lo es
        return pagoDAO.validarTarjeta(numeroTarjeta, fechaVencimiento, codigoSeguridad, nombreTitular);
    }

}
