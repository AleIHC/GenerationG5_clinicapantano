package com.clinica.clinicapantano.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Controlador para manejar vistas
@Controller
public class WebController {

    //Permite mostrar la vista del login, al acceder a la ruta
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String mostrarLogin() {
        return "login";//Retornando la vista login.html
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String mostrarHello() {
        return "hello";
    }


}
