package com.example.mascotafeliz.repository;

import com.example.mascotafeliz.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByEspecie(String especie);
    
    List<Paciente> findByPesoGreaterThan(Double peso);

    List<Paciente> findByEspecieAndNombre(String especie, String nombre);

    List<Paciente> findByEspecieOrderByPesoDesc(String especie);

}