package com.example.jdbc.ejerciciosjdbc.repository;

import java.sql.*;
import java.util.*;

import com.example.jdbc.ejerciciosjdbc.entity.Persona;

public class PersonaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/personas?serverTimezone=UTC";
    private static final String USER = "manu";
    private static final String PASS = "manu";
    private static Scanner scanner = new Scanner(System.in); 

    public Persona obtenerPersonaPorId(int idBuscado) {
        Persona persona = null;
        
        String sql = "SELECT p.nombre, d.calle " +
                     "FROM persona p " +
                     "INNER JOIN direccion d ON p.id = d.persona_id " +
                     "WHERE p.id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idBuscado);

            try (ResultSet rs = pstmt.executeQuery()) {
                            
                while (rs.next()) {
                    String nombreRecuperado = rs.getString("nombre");
                    String calleRecuperada = rs.getString("calle");

                    if (persona == null) {
                        persona = new Persona();
                        persona.setId(idBuscado);
                        persona.setNombre(nombreRecuperado);
                    }

                    persona.getDirecciones().add(calleRecuperada);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persona;
    }
    
    private static void createTable() {
    	String sql = "CREATE TABLE personas (id INTEGER PRIMARY KEY"
    			+ "AUTO_INCREMENT";
    	try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
    	} catch (SQLException ex) {
    		
    	}

    }
    
    public static void listarPersonas() {
    	String sql = "SELECT * FROM persona"; 
    	
    	try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
    			PreparedStatement pstmt = conn.prepareStatement(sql)) {
    		
    		ResultSet rs = pstmt.executeQuery(); 
    		
    		while (rs.next()) {
    			int id = rs.getInt("id"); 
    			String nombre = rs.getString("nombre"); 
    			System.out.println("ID: " + id + " - Nombre: " + nombre);
    		}
    				
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
    
    public static void insertarPersona() {
        String sql = "INSERT INTO persona (id, nombre) VALUES (?, ?)"; 
        
        System.out.println("Introduce el ID de la nueva persona:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Introduce el nombre de la nueva persona:");
        String nombre = scanner.nextLine();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.setString(2, nombre);
            
            pstmt.executeUpdate();
            System.out.println("Persona insertada correctamente.");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void eliminarPersona() {
        String sql = "DELETE FROM persona WHERE id = ?"; 
        
        System.out.println("Introduce el ID de la persona a eliminar:");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Persona eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna persona con ese ID.");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void cambiarNombreId(int id, String nuevoNombre) {
        String sql = "UPDATE persona SET nombre = ? WHERE id = ?";      
      
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoNombre); 
            pstmt.setInt(2, id);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Update successful.");
            } else {
                System.out.println("No user found with that ID.");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void buscarPersonasPorEdad(int edadMinima) {
        String sql = "SELECT * FROM persona WHERE edad >= ? ORDER BY edad";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = conn.prepareStatement(
                sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY)) { 
            
            pstmt.setInt(1, edadMinima);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    
                    Persona p = new Persona(id, nombre, edad, new ArrayList<>());
                    
                    System.out.println("Recuperado: " + p.toString());
                    
                    if (rs.isLast()) {
                        System.out.println(">>> ¡Esta es la última persona de la lista! <<<");
                    }
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }   	
}
