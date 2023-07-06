package com.clinica.clinicapantano.services;

import com.clinica.clinicapantano.entities.DoctorEntity;
import com.clinica.clinicapantano.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public DoctorEntity crearNuevoDoctor(DoctorEntity nuevoDoctor) {
        return doctorRepository.save(nuevoDoctor);
    }

    public List<DoctorEntity> buscarPorEspecialidad(String nombre) {
        return doctorRepository.buscarPorEspecialidad(nombre);
    }
}
