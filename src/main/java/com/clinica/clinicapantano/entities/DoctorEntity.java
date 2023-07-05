package com.clinica.clinicapantano.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "doctores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombreDoctor;

   @ManyToMany
   @JoinTable(
           name = "doctor_especialidad",
           joinColumns = @JoinColumn(name = "doctor_id"),
           inverseJoinColumns = @JoinColumn(name = "especialidad_id")
   )
   private List<EspecialidadEntity> especialidadesDoctor;

   @CreationTimestamp//Indica que el atributo siguiente es una fecha de creación
   private LocalDateTime createdAt;
   @UpdateTimestamp//Indica cuando un atributo se actualizó
   private LocalDateTime updatedAt;

   /**
   @JsonManagedReference//A quien pertenece la otra entidad
   @OneToMany(mappedBy = "doctorAsignado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<ConsultaEntity> consultasProgramadas;
   **/


}
