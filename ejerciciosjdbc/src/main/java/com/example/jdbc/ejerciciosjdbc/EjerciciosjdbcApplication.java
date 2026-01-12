package com.example.jdbc.ejerciciosjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jdbc.ejerciciosjdbc.entity.Persona;
import com.example.jdbc.ejerciciosjdbc.repository.PersonaDAO;

@SpringBootApplication
public class EjerciciosjdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosjdbcApplication.class, args);
		PersonaDAO dao = new PersonaDAO();

        // Probamos con el ID 1 (María) que sabemos que tiene 2 direcciones
        System.out.println("Buscando persona con ID 1...");
        Persona p = dao.obtenerPersonaPorId(1);

        if (p != null) {
            System.out.println("Encontrada: " + p.getNombre());
            System.out.println("Direcciones cargadas:");
            for (String dir : p.getDirecciones()) {
                System.out.println(" - " + dir);
            }
        } else {
            System.out.println("Persona no encontrada.");
        }
	}
	
	

}
