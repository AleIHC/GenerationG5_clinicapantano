package com.clinica.clinicapantano.services;

import com.clinica.clinicapantano.entities.ConsultaEntity;
import com.clinica.clinicapantano.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl implements ConsultaService{

    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public ConsultaEntity crearNuevaConsulta(ConsultaEntity nuevaConsulta) {
        ConsultaEntity consultaParaGuardar = consultaRepository.save(nuevaConsulta);
        return consultaParaGuardar;
    }
}
