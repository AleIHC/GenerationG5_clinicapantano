package com.clinica.clinicapantano.services;

import com.clinica.clinicapantano.entities.CategoriaEntity;
import com.clinica.clinicapantano.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public CategoriaEntity buscarPorId(Long id) {
        return categoriaRepository.findById(id).get();
    }
}
