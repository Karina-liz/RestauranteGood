package com.app.restaurante.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.restaurante.model.Cliente;
import com.app.restaurante.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpSession session;    
    
    // Cambiar el email por el user
    @PostMapping("/login")
    public ModelAndView login(
            @RequestParam("usuario") String usuario, 
            @RequestParam("contrasena") String password,
            RedirectAttributes redirectAttributes)
             throws NoSuchAlgorithmException, IOException, CloneNotSupportedException {
        
        Cliente cliente = loginService.validateUser(usuario, password);  // Validación de credenciales
        
        if (cliente != null) {
            // Almacena el cliente en la sesión
            session.setAttribute("idCliente", cliente.getIdCliente());
            session.setAttribute("usuario", cliente.getUsuario()); 
            session.setAttribute("nombre", cliente.getNombre());
           
            return new ModelAndView("redirect:/registro_completar");

        } else {
            // Mensaje si las credenciales son incorrectas
            redirectAttributes.addFlashAttribute("error", "Correo electrónico o contraseña inválidos");
            return new ModelAndView("redirect:/login");
        }
    }
    
    /* Nuevo método para manejar el cierre de sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalida la sesión actual y destruye todos los datos
        return "redirect:/login"; // Redirige a la página de inicio de sesión
    }*/
    
    // Cierra sesion, destruye los datos
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        // Invalidar la sesión
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalida la sesión y destruye
        }
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        
        return "redirect:/login";
    }

}

