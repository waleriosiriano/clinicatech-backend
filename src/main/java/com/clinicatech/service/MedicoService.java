package com.clinicatech.service;

import com.clinicatech.repository.MedicoRepository;
import com.clinicatech.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
