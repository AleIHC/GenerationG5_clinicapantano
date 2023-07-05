package com.clinica.clinicapantano.services;

import com.clinica.clinicapantano.entities.EspecialidadEntity;
import com.clinica.clinicapantano.repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServicImpl implements EspecialidadService {

    @Autowired
    EspecialidadRepository especialidadRepository;

    @Override
    public EspecialidadEntity buscarEspecialidadPorId(Long id) {
        return especialidadRepository.findById(id).get();
    }
}
