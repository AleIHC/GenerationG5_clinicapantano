package com.clinica.clinicapantano.controllers;

import com.clinica.clinicapantano.entities.DoctorEntity;
import com.clinica.clinicapantano.entities.EspecialidadEntity;
import com.clinica.clinicapantano.services.DoctorServiceImpl;
import com.clinica.clinicapantano.services.EspecialidadServicImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    DoctorServiceImpl doctorService;

    @Autowired
    EspecialidadServicImpl especialidadService;

    @PostMapping("/nuevo/{id}")
    public ResponseEntity<DoctorEntity> crearNuevoDoctor(@RequestBody DoctorEntity doctorEntity,
                                                         @PathVariable Long id) {
        //Creamos una variable donde guardamos al doctor que estamos ingresando
        DoctorEntity nuevoDoctor = doctorEntity;
        //Creamos una nueva lista de especialidades, vacía
        List<EspecialidadEntity> especialidadesDoctor = new ArrayList<>();
        //Buscamos la especialidad que nos están indicando y se la estamos agregando al arrayList vacío
        especialidadesDoctor.add(especialidadService.buscarEspecialidadPorId(id));
        //Al doctor nuevo le seteamos el atributo de especialidades
        nuevoDoctor.setEspecialidadesDoctor(especialidadesDoctor);

        return ResponseEntity.ok(doctorService.crearNuevoDoctor(nuevoDoctor));
    }

    @GetMapping("especialidad/{esp}")
    public ResponseEntity<List<DoctorEntity>> buscarPorEspecialidad(@PathVariable String esp) {
        return ResponseEntity.ok(doctorService.buscarPorEspecialidad(esp));
    }
}
