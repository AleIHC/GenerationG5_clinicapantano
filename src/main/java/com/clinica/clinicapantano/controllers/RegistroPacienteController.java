package com.clinica.clinicapantano.controllers;

import com.clinica.clinicapantano.entities.PersonajeEntity;
import com.clinica.clinicapantano.entities.RegistroPacienteEntity;
import com.clinica.clinicapantano.services.PersonajeServiceImpl;
import com.clinica.clinicapantano.services.RegistroPacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("paciente")
public class RegistroPacienteController {

    @Autowired
    RegistroPacienteServiceImpl registroPacienteService;

    @Autowired
    PersonajeServiceImpl personajeService;

    //Obtener lista de pacientes
    @GetMapping("/lista")
    public ResponseEntity<List<RegistroPacienteEntity>> obtenerTodosPacientes() {
        return ResponseEntity.ok(registroPacienteService.obtenerPacientesRegistrados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroPacienteEntity> obtenerPacientePorId(@PathVariable Long id) {
        return ResponseEntity.ok(registroPacienteService.buscarPacientePorId(id));
    }

    //Crear nuevo registro de paciente
    @PostMapping("/nuevo/{id}")
    public ResponseEntity<RegistroPacienteEntity> crearRegistro(@PathVariable Long id, @RequestBody RegistroPacienteEntity nuevoPaciente) {
        PersonajeEntity personajeElegido = personajeService.obtenerPersonajePorId(id).get();
        nuevoPaciente.setPersonajeEntity(personajeElegido);
        return ResponseEntity.ok(registroPacienteService.crearNuevoRegistro(nuevoPaciente));
    }
}
