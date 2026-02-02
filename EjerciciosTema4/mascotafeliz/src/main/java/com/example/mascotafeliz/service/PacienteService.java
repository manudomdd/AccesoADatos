package com.example.mascotafeliz.service;

import com.example.mascotafeliz.entity.Paciente;
import com.example.mascotafeliz.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public void actualizarPeso(Long id, Double nuevoPeso) {
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(id);

        if (pacienteEncontrado.isPresent()) {
            Paciente paciente = pacienteEncontrado.get();
            paciente.setPeso(nuevoPeso);
            pacienteRepository.save(paciente);
            System.out.println("Peso actualizado correctamente para: " + paciente.getNombre());
        } else {
            System.out.println("Error: No se encuentra la mascota con ID " + id);
        }
    }

    public void darDeBaja(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            System.out.println("Paciente con ID " + id + " eliminado correctamente.");
        } else {
            System.out.println("Error: No se puede dar de baja. No existe mascota con ID " + id);
        }
    }

    public List<Paciente> buscarPorEspecieYNombre(String especie, String nombre) {
        // Conectamos con el método que creamos antes en el Repositorio
        return pacienteRepository.findByEspecieAndNombre(especie, nombre);
    }
}