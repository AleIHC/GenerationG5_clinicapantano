package com.clinica.clinicapantano.services;




import com.clinica.clinicapantano.entities.PersonajeEntity;
import com.clinica.clinicapantano.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service//Con esto indicamos a Spring que estamos trabajando con un service
public class PersonajeServiceImpl implements PersonajeService {

    //@Override nos permite sobreescribir lo que habíamos declarado antes para el método, utilizando polimorfismo

    @Autowired//Inyección de dependencia del repository
    private PersonajeRepository personajeRepository;

    //Método para obtener una lista de personajes, definimos la lógica del método
    @Override
    public List<PersonajeEntity> obtenerPersonajes() {
        List<PersonajeEntity> listaPersonajes = personajeRepository.findAll();
        return listaPersonajes;
    }

    //En este método retornamos un Optional de nuestro objeto, es otro tipo de variable mas no es nuestro objeto como tal
    @Override
    public Optional<PersonajeEntity> obtenerPersonajePorId(Long id) {
        Optional<PersonajeEntity> personajeElegido = personajeRepository.findById(id);
        return personajeElegido;
    }

    @Override
    public PersonajeEntity guardarPersonaje(PersonajeEntity personajeEntity) {
        PersonajeEntity nuevoPersonaje = personajeRepository.save(personajeEntity);
        return nuevoPersonaje;
    }

    @Override
    public void borrarPersonajePorId(Long id) {
        personajeRepository.deleteById(id);
    }

    @Override
    public PersonajeEntity editarPersonajePorId(Long personajeId, PersonajeEntity personajeEditar) {

        Boolean existe = personajeRepository.existsById(personajeId);

        if (existe) {
            PersonajeEntity personajeSeleccionado = personajeRepository.findById(personajeId).get();
            personajeSeleccionado.setPersonajeEdad(personajeEditar.getPersonajeEdad());
            personajeSeleccionado.setPersonajeName(personajeEditar.getPersonajeName());
            personajeSeleccionado.setPersonajeEspecie(personajeEditar.getPersonajeEspecie());
            personajeSeleccionado.setPersonajeProfesion(personajeEditar.getPersonajeProfesion());
            return personajeRepository.save(personajeSeleccionado);
        }
        return null;
    }

}
