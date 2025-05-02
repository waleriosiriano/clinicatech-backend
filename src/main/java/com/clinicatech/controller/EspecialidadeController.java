package com.clinicatech.controller;

import com.clinicatech.model.Especialidade;
import com.clinicatech.repository.EspecialidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @PostMapping
    public ResponseEntity<Especialidade> criar(@RequestBody Especialidade especialidade) {
        Especialidade salva = especialidadeRepository.save(especialidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @GetMapping
    public List<Especialidade> listarTodas() {
        return especialidadeRepository.findAll();
    }
}
