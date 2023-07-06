package com.clinica.clinicapantano.services;

import com.clinica.clinicapantano.entities.MedicamentoEntity;
import com.clinica.clinicapantano.repositories.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Override
    public MedicamentoEntity guardarNuevoMedicamento(MedicamentoEntity nuevoMedicamento) {
        return medicamentoRepository.save(nuevoMedicamento);
    }

    public MedicamentoEntity buscarMedicamentoPorNombre(String nombre) {
        return medicamentoRepository.buscarMedicamentoPorNombre(nombre);
    }

    public List<MedicamentoEntity> buscarMedicamentoPorCategoria(String nombre) {
        return medicamentoRepository.listaDeMedicamentosPorCategoria(nombre);
    }

    @Override
    public List<MedicamentoEntity> listaDeMedicamentos() {
        return medicamentoRepository.findAll();
    }
}
