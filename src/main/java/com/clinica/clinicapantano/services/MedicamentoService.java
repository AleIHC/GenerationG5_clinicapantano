package com.clinica.clinicapantano.services;


import com.clinica.clinicapantano.entities.MedicamentoEntity;

import java.util.List;

public interface MedicamentoService {

    MedicamentoEntity guardarNuevoMedicamento(MedicamentoEntity nuevoMedicamento);

    List<MedicamentoEntity> listaDeMedicamentos();
}
