package com.app.restaurante.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.restaurante.dao.ReciboDAO;
import com.app.restaurante.model.Cliente;
import com.app.restaurante.model.Pedido;
import com.app.restaurante.model.Productos;
import com.app.restaurante.model.Recibo;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class ReciboController {
    
    @Autowired
    private HttpSession session;

    @Autowired
    private ReciboDAO reciboDao;

    @GetMapping("/recibo") // La accion DEBE HABER UN <a>
    public String mostrarRecibo(Model model) {
        // Este es el html
        return "recibo"; 
    }

    @GetMapping("/recibo/{idPedido}")
    public String mostrarRecibo(@PathVariable("idPedido") int idPedido,
                                Model model,
                                RedirectAttributes redirectAttributes) {

        // Verificar la sesión del cliente
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            redirectAttributes.addFlashAttribute("error", "Debe iniciar sesión para continuar.");
            return "redirect:/login";
        }

        // Obtener el recibo desde el ReciboDAO
        Recibo recibo = reciboDao.obtenerReciboPorIdPedido(idPedido);

        if (recibo == null) {
            redirectAttributes.addFlashAttribute("error", "No se encontró el recibo para este pedido.");
            return "redirect:/carrito_compra";
        }

        // Pasar el objeto Recibo al modelo
        model.addAttribute("recibo", recibo);

        return "recibo";
    }

    

    @GetMapping("/recibo_modal/{idPedido}")
    public String mostrarRecibo(@PathVariable Integer idPedido, Model model, RedirectAttributes redirectAttributes) {
        
        // Verificar la sesión del cliente
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            redirectAttributes.addFlashAttribute("error", "Debe iniciar sesión para continuar.");
            return "redirect:/login";
        }

        // Obtener el recibo desde el ReciboDAO
        Recibo recibo = reciboDao.obtenerReciboPorIdPedido(idPedido);

        if (recibo == null) {
            redirectAttributes.addFlashAttribute("error", "No se encontró el recibo para este pedido.");
            return "redirect:/carrito_compra";
        }

        // Pasar el objeto Recibo al modelo
        model.addAttribute("recibo", recibo);

        // Redirigir al modal de recibo (puedes hacer que devuelva una vista con los detalles del recibo)
        return "recibo"; // Esta es la vista donde mostrarás los detalles del recibo
    }
    
    
    /* 
    En la base de datos hemos creado una tabla que puede o no estar relacionada con el pago
    es la TABLA RECIBO que almacena los id en cadena de lo que se quiere
    asi manejamos todos los recibos, tenemos los id solo se harian consultas con todos los ID
    */
}

