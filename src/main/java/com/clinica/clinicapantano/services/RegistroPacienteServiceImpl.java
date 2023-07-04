package com.clinica.clinicapantano.services;

import com.clinica.clinicapantano.entities.RegistroPacienteEntity;
import com.clinica.clinicapantano.repositories.RegistroPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroPacienteServiceImpl implements RegistroPacienteService {

    @Autowired
    RegistroPacienteRepository registroPacienteRepository;

    @Override
    public List<RegistroPacienteEntity> obtenerPacientesRegistrados() {
        List<RegistroPacienteEntity> listaDePacientes = registroPacienteRepository.findAll();
        return listaDePacientes;
    }

    @Override
    public RegistroPacienteEntity crearNuevoRegistro(RegistroPacienteEntity nuevoPaciente) {
        RegistroPacienteEntity registroNuevo = registroPacienteRepository.save(nuevoPaciente);
        return registroNuevo;
    }

}
