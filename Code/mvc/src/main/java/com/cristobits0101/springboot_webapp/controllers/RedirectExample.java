package com.cristobits0101.springboot_webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectExample {

    // Redireciona a una plantilla.
    @GetMapping({ "", "/", "/home" })
    public String home() {
        return "redirect:/inicio";
    }

    /**
     * Redirecciona a un handler (método de api que controla peticiones de usuario).
     * JSP or Servlet
     * Se mantiene dentro de la misma ruta http y no pierde los parámetros
     */
    @GetMapping({ "", "/", "/home" })
    public String home2() {
        return "forward:/book";
    }

}
