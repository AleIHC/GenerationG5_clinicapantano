package com.clinica.clinicapantano.services;


import com.clinica.clinicapantano.entities.PersonajeEntity;

import java.util.List;
import java.util.Optional;

//Interfaz del service donde declaramos los métodos, por eso es una interfaz
public interface PersonajeService {

    //Declaramos el primer método que es para traernos una lista de los personaje
    List<PersonajeEntity> obtenerPersonajes();
    Optional<PersonajeEntity> obtenerPersonajePorId(Long id);

    PersonajeEntity guardarPersonaje(PersonajeEntity personajeEntity);

    void borrarPersonajePorId(Long id);

    PersonajeEntity editarPersonajePorId(Long id, PersonajeEntity personajeEntity);
}
