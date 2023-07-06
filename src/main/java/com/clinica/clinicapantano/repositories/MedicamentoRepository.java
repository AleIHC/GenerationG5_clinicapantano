package com.clinica.clinicapantano.repositories;

import com.clinica.clinicapantano.entities.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Long> {

    //JPQL - Java Persistence Query Language

    @Query(value = "SELECT * FROM medicamentos m WHERE m.nombre_medicamento LIKE ?1 ", nativeQuery = true)
    MedicamentoEntity buscarMedicamentoPorNombre(String nombre);


    @Query(value = "select distinct * from medicamentos m inner join categorias_medicamentos cm on m.medicamento_id = cm.id_medicamento" +
            " inner join categorías c on c.categoria_id = cm.categoria_id where nombre_categoria = ?1 ", nativeQuery = true)
    List<MedicamentoEntity> listaDeMedicamentosPorCategoria(String nombre);
}
