package com.clinica.clinicapantano.services;

import com.clinica.clinicapantano.entities.RegistroPacienteEntity;

import java.util.List;

public interface RegistroPacienteService {

    //Va a traer la lista
    List<RegistroPacienteEntity> obtenerPacientesRegistrados();

    //Va a guardar un nuevo paciente
    public RegistroPacienteEntity crearNuevoRegistro(RegistroPacienteEntity nuevoPersonaje);

    public RegistroPacienteEntity buscarPacientePorId(Long id);
}
