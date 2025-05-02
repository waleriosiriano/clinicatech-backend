package com.clinicatech.controller;

import com.clinicatech.dto.ConsultaDTO;
import com.clinicatech.model.Consulta;
import com.clinicatech.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public Consulta agendarConsulta(@RequestBody ConsultaDTO dto) {
        return consultaService.agendarConsulta(dto);
    }

    @GetMapping
    public List<Consulta> listarConsultas() {
        return consultaService.listarTodas();
    }

    @DeleteMapping("/{id}")
    public void cancelarConsulta(@PathVariable Long id) {
        consultaService.cancelarConsulta(id);
    }
}
