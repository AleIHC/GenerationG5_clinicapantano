package com.clinica.clinicapantano.controllers;


import com.clinica.clinicapantano.services.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaServiceImpl categoriaService;
}
