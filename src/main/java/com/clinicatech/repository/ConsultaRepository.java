package com.clinicatech.repository;

import com.clinicatech.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Optional<Consulta> findByPacienteIdAndDataHora(Long pacienteId, LocalDateTime dataHora);
}
