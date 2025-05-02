package com.clinicatech.controller;

import com.clinicatech.model.AnotacaoMedica;
import com.clinicatech.service.AnotacaoMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anotacoes")
public class AnotacaoMedicaController {

    @Autowired
    private AnotacaoMedicaService anotacaoMedicaService;

    @PostMapping
    public ResponseEntity<AnotacaoMedica> criar(@RequestBody AnotacaoMedica anotacao) {
        AnotacaoMedica salva = anotacaoMedicaService.salvar(anotacao);
        return ResponseEntity.ok(salva);
    }

    @GetMapping
    public List<AnotacaoMedica> listarTodas() {
        return anotacaoMedicaService.listarTodas();
    }

    @GetMapping("/consulta/{idConsulta}")
    public List<AnotacaoMedica> listarPorConsulta(@PathVariable String idConsulta) {
        return anotacaoMedicaService.listarPorConsulta(idConsulta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnotacaoMedica> buscarPorId(@PathVariable String id) {
        return anotacaoMedicaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        anotacaoMedicaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
