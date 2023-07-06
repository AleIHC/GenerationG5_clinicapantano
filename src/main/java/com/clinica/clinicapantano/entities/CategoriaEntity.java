package com.clinica.clinicapantano.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorías")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoriaId;
    private String nombreCategoria;

    @ManyToMany
    @JoinTable(
            name = "categorias_medicamentos",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<MedicamentoEntity> medicamentosCategoria;

}
