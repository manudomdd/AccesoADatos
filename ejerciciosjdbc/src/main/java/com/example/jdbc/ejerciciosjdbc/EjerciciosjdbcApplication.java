package com.example.jdbc.ejerciciosjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jdbc.ejerciciosjdbc.entity.Persona;
import com.example.jdbc.ejerciciosjdbc.repository.PersonaDAO;
import com.example.jdbc.ejerciciosjdbc.repository.TelefonoDAO;

import java.util.*;

@SpringBootApplication
public class EjerciciosjdbcApplication {
	
	public static Scanner scanner = new Scanner(System.in); 

	public static void main(String[] args) {
		SpringApplication.run(EjerciciosjdbcApplication.class, args);
		PersonaDAO dao = new PersonaDAO();
		TelefonoDAO tlfDAO = new TelefonoDAO(); 

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
        
        System.out.println("¿Desea crear una nueva tabla para los telefonos?: "); 
        System.out.println("1. Si."); 
        System.out.println("2. No."); 
        int election = scanner.nextInt(); 
        switch (election) {
        case 1 -> {tlfDAO.crearTableTelefono();}
        case 2 -> {return;}
        default -> {System.out.println("Opcion no valida.");}
        }
	}
}
