package com.example.mascotafeliz.controller;

import com.example.mascotafeliz.entity.Paciente;
import com.example.mascotafeliz.service.PacienteService;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscar")
    public List<Paciente> buscar(@RequestParam String especie, @RequestParam String nombre) {
        return pacienteService.buscarPorEspecieYNombre(especie, nombre);
    }

    @PutMapping("/{id}/peso")
    public String actualizarPeso(@PathVariable Long id, @RequestParam Double nuevoPeso) {
        pacienteService.actualizarPeso(id, nuevoPeso);
        return "Proceso de actualización ejecutado. Revisa la consola para ver el resultado.";
    }

    @DeleteMapping("/{id}")
    public String darDeBaja(@PathVariable Long id) {
        pacienteService.darDeBaja(id);
        return "Proceso de baja ejecutado. Revisa la consola para ver el resultado.";
    }
}