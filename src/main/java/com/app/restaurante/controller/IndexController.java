package com.app.restaurante.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping("/bienvenido")
    public String bienvenida() {
        return "bienvenido";  // Asegúrate de que hay una vista llamada bienvenido.html
    }
}
