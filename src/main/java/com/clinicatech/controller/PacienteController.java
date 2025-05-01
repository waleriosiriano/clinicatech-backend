package com.clinicatech.controller;

import com.clinicatech.model.Paciente;
import com.clinicatech.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Esta classe expõe a API REST para acesso externo
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Endpoint para cadastrar um novo paciente
    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente) {
        return ResponseEntity.status(201).body(pacienteService.salvar(paciente));
    }

    // Endpoint para listar todos os pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }
}
