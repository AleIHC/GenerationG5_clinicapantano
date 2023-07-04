package com.clinica.clinicapantano.controllers;

import com.clinica.clinicapantano.entities.ConsultaEntity;
import com.clinica.clinicapantano.entities.RegistroPacienteEntity;
import com.clinica.clinicapantano.services.ConsultaServiceImpl;
import com.clinica.clinicapantano.services.RegistroPacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    ConsultaServiceImpl consultaService;

    @Autowired
    RegistroPacienteServiceImpl registroPacienteService;

    @PostMapping("/nueva/{id}")
    public ResponseEntity<ConsultaEntity> crearNuevaConsulta(@PathVariable Long id,
                                                             @RequestBody ConsultaEntity nuevaConsulta) {
        RegistroPacienteEntity pacienteElegido = registroPacienteService.buscarPacientePorId(id);
        nuevaConsulta.setPacienteConsulta(pacienteElegido);
        return ResponseEntity.ok(consultaService.crearNuevaConsulta(nuevaConsulta));
    }

}
