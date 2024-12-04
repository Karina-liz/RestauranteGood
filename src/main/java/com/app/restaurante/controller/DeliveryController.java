package com.app.restaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeliveryController {
    
    @GetMapping("/delivery")
    public String mostrarDelivery(Model model) {
        
        return "delivery";  // Nombre de la vista Thymeleaf
    }
}
