package com.clinicatech.service;

import com.clinicatech.repository.MedicoRepository;
import com.clinicatech.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	public Medico salvar(Medico medico) {
		return medicoRepository.save(medico);
	}
	
	public List<Medico> listarTodos(){
		return medicoRepository.findAll();
	}
	
	// MedicoService.java

	public Optional<Medico> buscarPorId(Long id) {
	    return medicoRepository.findById(id);
	}

	public Medico atualizar(Medico medico) {
	    return medicoRepository.save(medico);
	}

	public void deletar(Long id) {
	    medicoRepository.deleteById(id);
	}

}
