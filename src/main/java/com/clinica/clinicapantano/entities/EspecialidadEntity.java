package com.clinica.clinicapantano.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "especialidades")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EspecialidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long especialidadId;
    private String nombreEspecialidad;

    @JsonIgnore//JsonIgnore permite solucionar la recursividad, ignorando esta entidad cuando consultemos por la dueña de la relación
    @ManyToMany//Anotación para indicar relación n:n
    @JoinTable(//Crear tabla relacional, va a recibir 3 argumentos
            name = "doctor_especialidad",//Nombre de la tabla relacional
            joinColumns = @JoinColumn(name = "especialidad_id"),//El nombre de la columna que lleva la llave foránea de la entidad que estemos trabajando
            inverseJoinColumns = @JoinColumn(name = "doctor_id")//El nombre de la columna que lleva la llave foránea de la otra entidad
    )
    private List<DoctorEntity> doctoresEspecialidad;

    @CreationTimestamp//Indica que el atributo siguiente es una fecha de creación
    private LocalDateTime createdAt;
    @UpdateTimestamp//Indica cuando un atributo se actualizó
    private LocalDateTime updatedAt;

}
