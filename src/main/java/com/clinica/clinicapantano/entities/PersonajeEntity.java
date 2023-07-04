package com.clinica.clinicapantano.entities;

import jakarta.persistence.*;

@Entity//Con esto indicamos que es una entidad para ser respresentada en la BDD
@Table(name = "personajes")//Acá indicamos el nombre que tendrá la tabla
public class PersonajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personajeId;
    private String personajeName;
    private Integer personajeEdad;
    private String personajeEspecie;
    @Column(name = "profesion")
    private String personajeProfesion;


    //Constructor lleno
    public PersonajeEntity(String personajeName, Integer personajeEdad, String personajeEspecie, String personajeProfesion) {
        this.personajeName = personajeName;
        this.personajeEdad = personajeEdad;
        this.personajeEspecie = personajeEspecie;
        this.personajeProfesion = personajeProfesion;
    }

    //Constructor vacío
    public PersonajeEntity() {
    }

    //Getter y Setter
    public Long getPersonajeId() {
        return personajeId;
    }

    public String getPersonajeName() {
        return personajeName;
    }

    public void setPersonajeName(String personajeName) {
        this.personajeName = personajeName;
    }

    public Integer getPersonajeEdad() {
        return personajeEdad;
    }

    public void setPersonajeEdad(Integer personajeEdad) {
        this.personajeEdad = personajeEdad;
    }

    public String getPersonajeEspecie() {
        return personajeEspecie;
    }

    public void setPersonajeEspecie(String personajeEspecie) {
        this.personajeEspecie = personajeEspecie;
    }

    public String getPersonajeProfesion() {
        return personajeProfesion;
    }

    public void setPersonajeProfesion(String personajeProfesion) {
        this.personajeProfesion = personajeProfesion;
    }


}
