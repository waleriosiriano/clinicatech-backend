package com.clinicatech.controller;

import com.clinicatech.dto.MedicoDTO;
import com.clinicatech.model.Especialidade;
import com.clinicatech.model.Medico;
import com.clinicatech.repository.EspecialidadeRepository;
import com.clinicatech.service.MedicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @PostMapping
    public ResponseEntity<Medico> cadastrar(@RequestBody MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setNome(medicoDTO.getNome());
        medico.setCrm(medicoDTO.getCrm());
        medico.setTelefone(medicoDTO.getTelefone());
        medico.setDataNascimento(medicoDTO.getDataNascimento());

        // Buscar as especialidades pelos IDs
        Set<Especialidade> especialidades = new HashSet<>();
        for (Long id : medicoDTO.getEspecialidadeIds()) {
            Optional<Especialidade> especialidade = especialidadeRepository.findById(id);
            especialidade.ifPresent(especialidades::add);
        }

        medico.setEspecialidades(especialidades);

        Medico salvo = medicoService.salvar(medico);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public List<Medico> listarTodos() {
        return medicoService.listarTodos();
    }
    
 // Buscar médico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Long id) {
        Optional<Medico> medico = medicoService.buscarPorId(id);
        return medico.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Atualizar médico
    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizar(@PathVariable Long id, @RequestBody MedicoDTO medicoDTO) {
        Optional<Medico> existente = medicoService.buscarPorId(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Medico medico = existente.get();
        medico.setNome(medicoDTO.getNome());
        medico.setCrm(medicoDTO.getCrm());
        medico.setTelefone(medicoDTO.getTelefone());
        medico.setDataNascimento(medicoDTO.getDataNascimento());

        Set<Especialidade> especialidades = new HashSet<>();
        for (Long espId : medicoDTO.getEspecialidadeIds()) {
            especialidadeRepository.findById(espId).ifPresent(especialidades::add);
        }
        medico.setEspecialidades(especialidades);

        Medico atualizado = medicoService.atualizar(medico);
        return ResponseEntity.ok(atualizado);
    }

    // Deletar médico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (medicoService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        medicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
