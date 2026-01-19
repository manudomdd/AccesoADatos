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

        int opcion = 0;

        do {
            System.out.println("\n--- GESTIÓN DE BASE DE DATOS ---");
            System.out.println("1. Listar personas");
            System.out.println("2. Insertar nueva persona");
            System.out.println("3. Modificar nombre por ID");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Buscar persona (Ejemplo ID 1)");
            System.out.println("6. Crear tabla Teléfonos");
            System.out.println("7. Buscar personas por edad");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1 -> dao.listarPersonas();
                    case 2 -> dao.insertarPersona();
                    case 3 -> {
                        System.out.println("Introduce el ID:");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.println("Introduce el nuevo nombre:");
                        String nuevoNombre = scanner.nextLine();
                        
                        dao.cambiarNombreId(id, nuevoNombre);
                    }
                    case 4 -> dao.eliminarPersona();
                    case 5 -> {
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
                    case 6 -> tlfDAO.crearTableTelefono();
                    case 7 -> {
                        System.out.println("Introduce la edad mínima:");
                        int edad = scanner.nextInt();
                        scanner.nextLine();
                        
                        dao.buscarPersonasPorEdad(edad);
                    }
                    case 8 -> System.out.println("Cerrando aplicación...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada de datos.");
                scanner.nextLine(); 
            }
        } while (opcion != 8);
    }
}