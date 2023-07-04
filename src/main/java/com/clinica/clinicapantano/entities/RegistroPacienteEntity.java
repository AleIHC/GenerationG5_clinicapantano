package com.clinica.clinicapantano.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class RegistroPacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registroId;

    private String prevision;

    //Esta anotación indica la relación de 1 a 1 y permite crear una columna con la llave foránea
    @OneToOne
    private PersonajeEntity personajeEntity;

    @JsonManagedReference//Indicamos que es la dueña de la relación
    @OneToMany(mappedBy = "pacienteConsulta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ConsultaEntity> consultasPaciente;

    //Fechas de auditoria
    @CreationTimestamp//Indica que el atributo siguiente es una fecha de creación
    private LocalDateTime createdAt;
    @UpdateTimestamp//Indica cuando un atributo se actualizó
    private LocalDateTime updatedAt;

    //Constructores
    public RegistroPacienteEntity() {
    }

    public RegistroPacienteEntity(Long registroId, String prevision, PersonajeEntity personajeEntity) {
        this.registroId = registroId;
        this.prevision = prevision;
        this.personajeEntity = personajeEntity;
    }

    //Getter y setter
    public Long getRegistroId() {
        return registroId;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public PersonajeEntity getPersonajeEntity() {
        return personajeEntity;
    }

    public void setPersonajeEntity(PersonajeEntity personajeEntity) {
        this.personajeEntity = personajeEntity;
    }
}
