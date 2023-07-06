package com.clinica.clinicapantano.services;

import com.clinica.clinicapantano.repositories.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{

    @Autowired
    MedicamentoRepository medicamentoRepository;


}
