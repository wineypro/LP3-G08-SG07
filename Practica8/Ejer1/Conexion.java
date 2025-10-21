package Ejer1;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:sqlite:datos.db";

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            crearTabla(conn);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return conn;
    }

    private static void crearTabla(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS empleados (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nombre TEXT NOT NULL, " +
                     "cargo TEXT NOT NULL, " +
                     "salario REAL NOT NULL, " +
                     "edad INTEGER NOT NULL)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}

