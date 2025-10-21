package Ejer1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDatos {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:datos.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Base de datos 'datos.db' creada o abierta correctamente.");

                String sql = "CREATE TABLE IF NOT EXISTS empleados (" +
                             "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                             "nombre TEXT NOT NULL, " +
                             "cargo TEXT NOT NULL, " +
                             "salario REAL NOT NULL, " +
                             "edad INTEGER NOT NULL)";
                Statement stmt = conn.createStatement();
                stmt.execute(sql);

                System.out.println("Tabla 'empleados' creada correctamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }
    }
}

