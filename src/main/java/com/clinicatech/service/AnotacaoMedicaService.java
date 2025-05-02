package com.clinicatech.service;

import com.clinicatech.model.AnotacaoMedica;
import com.clinicatech.repository.AnotacaoMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnotacaoMedicaService {

    @Autowired
    private AnotacaoMedicaRepository anotacaoMedicaRepository;

    public AnotacaoMedica salvar(AnotacaoMedica anotacao) {
        return anotacaoMedicaRepository.save(anotacao);
    }

    public List<AnotacaoMedica> listarTodas() {
        return anotacaoMedicaRepository.findAll();
    }

    public List<AnotacaoMedica> listarPorConsulta(String idConsulta) {
        return anotacaoMedicaRepository.findByIdConsulta(idConsulta);
    }

    public Optional<AnotacaoMedica> buscarPorId(String id) {
        return anotacaoMedicaRepository.findById(id);
    }

    public void deletar(String id) {
        anotacaoMedicaRepository.deleteById(id);
    }
}
