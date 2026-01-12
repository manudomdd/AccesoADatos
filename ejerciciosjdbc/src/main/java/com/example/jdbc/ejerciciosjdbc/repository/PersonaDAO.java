package com.example.jdbc.ejerciciosjdbc.repository;

import java.sql.*;

import com.example.jdbc.ejerciciosjdbc.entity.Persona;

public class PersonaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/personas?serverTimezone=UTC";
    private static final String USER = "manu";
    private static final String PASS = "manu";

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
}
