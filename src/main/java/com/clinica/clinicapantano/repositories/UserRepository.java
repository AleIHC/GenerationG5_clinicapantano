package com.clinica.clinicapantano.repositories;

import com.clinica.clinicapantano.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //Buscar entidad por username
    UserEntity findUserEntityByUsername(String username);
}
