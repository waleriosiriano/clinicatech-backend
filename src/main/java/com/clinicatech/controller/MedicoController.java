package com.clinicatech.controller;

import org.springframework.http.ResponseEntity;
import com.clinicatech.model.Medico;
import com.clinicatech.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

	@Autowired
	private MedicoService medicoService;
	
	@PostMapping
	public ResponseEntity<Medico> salvar(@RequestBody Medico medico){
		return ResponseEntity.status(201).body(medicoService.salvar(medico));
	}
	
	@GetMapping
	public ResponseEntity<List<Medico>> listarTodos(){
		return ResponseEntity.ok(medicoService.listarTodos());
	}
}
