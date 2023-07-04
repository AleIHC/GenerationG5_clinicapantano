package com.clinica.clinicapantano.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "consultas")
@NoArgsConstructor//Constructor Vacío
@AllArgsConstructor//Constructor LLeno
@Getter//Getters
@Setter//Setters
public class ConsultaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultaId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date fechaConsulta;
    private String motivoConsulta;

    @JsonBackReference//Indicamos que consulta pertenece a paciente
    @ManyToOne
    @JoinColumn(name= "registro_id")//Indicamos el nombre de la columna donde está la llave foránea
    private RegistroPacienteEntity pacienteConsulta;

}
