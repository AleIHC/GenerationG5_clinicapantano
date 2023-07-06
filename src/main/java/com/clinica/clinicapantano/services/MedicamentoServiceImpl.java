package com.clinica.clinicapantano.services;

import com.clinica.clinicapantano.entities.MedicamentoEntity;
import com.clinica.clinicapantano.repositories.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Override
    public MedicamentoEntity guardarNuevoMedicamento(MedicamentoEntity nuevoMedicamento) {
        return medicamentoRepository.save(nuevoMedicamento);
    }
}
