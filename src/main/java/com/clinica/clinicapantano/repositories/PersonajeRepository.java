package com.clinica.clinicapantano.repositories;



import com.clinica.clinicapantano.entities.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {


}
