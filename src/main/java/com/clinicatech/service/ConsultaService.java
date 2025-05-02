package com.clinicatech.service;

import com.clinicatech.dto.ConsultaDTO;
import com.clinicatech.model.Consulta;
import com.clinicatech.model.Paciente;
import com.clinicatech.repository.ConsultaRepository;
import com.clinicatech.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public Consulta agendarConsulta(ConsultaDTO dto) {
        if (consultaRepository.findByPacienteIdAndDataHora(dto.getPacienteId(), dto.getDataHora()).isPresent()) {
            throw new RuntimeException("Já existe uma consulta marcada neste horário para este paciente.");
        }

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado."));

        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setMotivo(dto.getMotivo());
        consulta.setPaciente(paciente);
        consulta.setCancelada(false);

        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    public void cancelarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.setCancelada(true); // Remoção lógica
        consultaRepository.save(consulta);
    }
}
