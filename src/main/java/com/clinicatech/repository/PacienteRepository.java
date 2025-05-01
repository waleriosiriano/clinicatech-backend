package com.clinicatech.repository;

import com.clinicatech.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface responsável por interagir com o banco de dados
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
   
}
