package com.clinica.clinicapantano.repositories;


import com.clinica.clinicapantano.entities.RegistroPacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroPacienteRepository extends JpaRepository<RegistroPacienteEntity, Long> {

}
