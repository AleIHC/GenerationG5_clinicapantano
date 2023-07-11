package com.clinica.clinicapantano.repositories;

import com.clinica.clinicapantano.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {

    RolEntity findRolEntityByNombreRol(String nombre);
}
