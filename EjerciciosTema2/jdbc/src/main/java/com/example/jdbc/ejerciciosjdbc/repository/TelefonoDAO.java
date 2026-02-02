package com.example.jdbc.ejerciciosjdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TelefonoDAO {
	
    private static final String URL = "jdbc:mysql://localhost:3306/personas?serverTimezone=UTC";
    private static final String USER = "manu";
    private static final String PASS = "manu";
    
    public void crearTableTelefono() {
        
        String sqlCreate = "CREATE TABLE telefono (" +
                           "id INT NOT NULL, " +
                           "numero VARCHAR(20), " +
                           "tipo VARCHAR(50), " +
                           "persona_id INT, " +
                           "PRIMARY KEY (id), " +
                           "CONSTRAINT fk_persona_tel FOREIGN KEY (persona_id) REFERENCES persona(id)" +
                           ")";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            stmt.execute("DROP TABLE IF EXISTS telefono");
            stmt.execute(sqlCreate);
            
            stmt.executeUpdate("INSERT INTO telefono (id, numero, tipo, persona_id) VALUES (500, '+34 600 123 456', 'Móvil Personal', 1)");
            stmt.executeUpdate("INSERT INTO telefono (id, numero, tipo, persona_id) VALUES (501, '+34 910 000 000', 'Trabajo', 1)");
            stmt.executeUpdate("INSERT INTO telefono (id, numero, tipo, persona_id) VALUES (502, '+34 655 987 654', 'Móvil', 2)");
            
            System.out.println("Tabla telefono creada y datos insertados correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}