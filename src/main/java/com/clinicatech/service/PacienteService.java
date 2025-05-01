package com.clinicatech.service;

import com.clinicatech.model.Paciente;
import com.clinicatech.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Esta classe representa as regras de negócio para Pacientes
@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Salva um novo paciente no banco
    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Lista todos os pacientes cadastrados
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }
}
