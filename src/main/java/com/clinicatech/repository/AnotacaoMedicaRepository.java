package com.clinicatech.repository;

import com.clinicatech.model.AnotacaoMedica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnotacaoMedicaRepository extends MongoRepository<AnotacaoMedica, String> {
    
    // Buscar todas as anotações de uma consulta específica
    List<AnotacaoMedica> findByIdConsulta(String idConsulta);
}
