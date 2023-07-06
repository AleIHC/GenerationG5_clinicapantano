package com.clinica.clinicapantano.repositories;

import com.clinica.clinicapantano.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

    @Query(value = "SELECT d.doctor_id FROM doctores d inner join doctor_especialidad de inner join especialidades e where e.nombre_especialidad = ?1" , nativeQuery = true)
    List<DoctorEntity> buscarPorEspecialidad(String nombre);
}
