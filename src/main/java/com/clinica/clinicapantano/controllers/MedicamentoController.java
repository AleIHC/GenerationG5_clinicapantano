package com.clinica.clinicapantano.controllers;

import com.clinica.clinicapantano.entities.CategoriaEntity;
import com.clinica.clinicapantano.entities.MedicamentoEntity;
import com.clinica.clinicapantano.services.CategoriaServiceImpl;
import com.clinica.clinicapantano.services.MedicamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    MedicamentoServiceImpl medicamentoService;

    @Autowired
    CategoriaServiceImpl categoriaService;

    @PostMapping("/nuevo/{id}")
    public ResponseEntity<MedicamentoEntity> guardarNuevoMedicamento(@PathVariable Long id,
                                                                     @RequestBody MedicamentoEntity nuevoMedicamento) {
        CategoriaEntity categoriaMedicamento = categoriaService.buscarPorId(id);
        List<CategoriaEntity> categoriasMedicamento = new ArrayList<>();
        categoriasMedicamento.add(categoriaMedicamento);
        nuevoMedicamento.setCategoriasMedicamento(categoriasMedicamento);
        return ResponseEntity.ok(medicamentoService.guardarNuevoMedicamento(nuevoMedicamento));
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<MedicamentoEntity> buscarMedicamentoPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(medicamentoService.buscarMedicamentoPorNombre(nombre));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<MedicamentoEntity>> listaDeMedicamentos() {
        return ResponseEntity.ok(medicamentoService.listaDeMedicamentos());
    }

    @GetMapping("categoria/{cat}")
    public  ResponseEntity<List<MedicamentoEntity>> buscarMedicamentosPorCategoria(@PathVariable String cat) {
        return ResponseEntity.ok(medicamentoService.buscarMedicamentoPorCategoria(cat));
    }



}
