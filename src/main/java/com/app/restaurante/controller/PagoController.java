package com.app.restaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.restaurante.dao.DeliveryDAO;
import com.app.restaurante.dao.PagoDAO;
import com.app.restaurante.model.Cliente;
import com.app.restaurante.service.EmailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PagoController {

    @Autowired
    private HttpSession session;

    @Autowired
    private PagoDAO pagoDao;
    
    @Autowired
    private EmailService emailService;


    @Autowired
    private DeliveryDAO deliveryDao;

    @PostMapping("/guardarPago")
    public String procesarPago(@RequestParam("idPedido") Long idPedido, 
                               @RequestParam("montoTotal") Double total, 
                               @RequestParam("nombreTitular") String nombreTitular,
                               @RequestParam("numeroTarjeta") String numeroTarjeta,
                               @RequestParam("fechaVencimiento") String fechaVencimiento,
                               @RequestParam("codigoSeguridad") String codigoSeguridad,
                               RedirectAttributes redirectAttributes) {
        
        // Verifico session
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        if (cliente == null) {
            redirectAttributes.addFlashAttribute("error", "Debe iniciar sesión para continuar.");
            return "redirect:/login";
        }

        // Valida si los datos estan vacios
        if (idPedido == null || total == null || total <= 0 || 
            nombreTitular == null || numeroTarjeta == null || 
            fechaVencimiento == null || codigoSeguridad == null) {
            redirectAttributes.addFlashAttribute("error", "Datos de pago inválidos.");
            return "redirect:/carrito_compra";
        }

        // Validar los datos de la tarjeta
        if (!validarDatosTarjeta(numeroTarjeta, fechaVencimiento, codigoSeguridad, nombreTitular)) {
            redirectAttributes.addFlashAttribute("error", "Datos de tarjeta inválidos.");
            return "redirect:/carrito_compra";
        }

        

        try {            
            pagoDao.registrarPago(idPedido, total);
            pagoDao.actualizarEstadoPedido(idPedido, "Pagado");
            deliveryDao.registrarDelivery(idPedido);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al procesar el pago: " + e.getMessage());
            return "redirect:/carrito_compra";
        }

        try {            
            pagoDao.actualizarEstadoPedido(idPedido, "Pagado");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el estado del pedido: " + e.getMessage());
            return "redirect:/carrito_compra";
        }

        // Enviar correo de confirmación
        try {
            String destinatario = (String) session.getAttribute("correo");
            //String destinatario = cliente.getCorreo();
            String asunto = "Confirmación de pago - Pedido #" + idPedido;
            String cuerpo = "Estimado " + cliente.getNombre() + " " + cliente.getApellido() + ",\n\n" +
                            "Gracias por tu compra. El pago por el pedido #" + idPedido + " se ha procesado exitosamente.\n" +
                            "Monto total: $" + total + "\n\n" +
                            "Estamos preparando tu pedido para su entrega.\n\n" +
                            "Saludos,\nEl equipo de Restaurante.";
            System.out.println(destinatario);
            emailService.enviarCorreo(destinatario, asunto, cuerpo);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Pago registrado, pero no se pudo enviar el correo: " + e.getMessage());
        }

        
        // Retraso de 2 segundos antes de redirigir
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        redirectAttributes.addFlashAttribute("mensaje", "Pago procesado exitosamente.");

        System.out.println(idPedido);
        System.out.println(idPedido);
        System.out.println(idPedido);

        return "redirect:/recibo/" + idPedido;
    }

    // Método para validar los datos de la tarjeta usando PagoDAO
    private boolean validarDatosTarjeta(String numeroTarjeta, String fechaVencimiento, String codigoSeguridad, String nombreTitular) {
        return pagoDao.validarTarjeta(numeroTarjeta, fechaVencimiento, codigoSeguridad, nombreTitular);
    }
}
