package com.clinicatech.controller;

import com.clinicatech.dto.MedicoDTO;
import com.clinicatech.model.Especialidade;
import com.clinicatech.model.Medico;
import com.clinicatech.repository.EspecialidadeRepository;
import com.clinicatech.repository.MedicoRepository;

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
    private MedicoRepository medicoRepository;

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

        Medico salvo = medicoRepository.save(medico);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public List<Medico> listarTodos() {
        return medicoRepository.findAll();
    }
}
