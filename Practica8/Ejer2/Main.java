package Ejer2;

import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String CLAVE = "1234";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conn = Conexion.conectar();

        if (conn == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Ingresar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Consultar desde arreglo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> ingresarEmpleado(conn, sc);
                case 2 -> mostrarEmpleados(conn);
                case 3 -> actualizarEmpleado(conn, sc);
                case 4 -> eliminarEmpleado(conn, sc);
                case 5 -> {
                    try (Connection nuevaConn = Conexion.conectar()) {
                        GestorEmpleados gestor = new GestorEmpleados(nuevaConn);
                        gestor.consultar(sc);
                    } catch (SQLException e) {
                        System.out.println("Error al consultar empleados: " + e.getMessage());
                    }
                }
                case 6 -> {
                	System.out.println("Saliendo del programa...");
                	conn.close();
                }
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 6);
    }

    private static boolean verificarClave(Scanner sc) {
        System.out.print("Ingrese la clave de confirmación: ");
        String clave = sc.nextLine();
        return clave.equals(CLAVE);
    }

    private static void ingresarEmpleado(Connection conn, Scanner sc) {
        try {
            conn.setAutoCommit(false);

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Cargo: ");
            String cargo = sc.nextLine();
            System.out.print("Salario: ");
            double salario = sc.nextDouble();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            if (!verificarClave(sc)) {
                System.out.println("Clave incorrecta. Operación cancelada.");
                conn.rollback();
                return;
            }

            String sql = "INSERT INTO empleados(nombre, cargo, salario, edad) VALUES(?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, cargo);
                pstmt.setDouble(3, salario);
                pstmt.setInt(4, edad);
                pstmt.executeUpdate();
            }
            conn.commit();
            System.out.println("Empleado ingresado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al ingresar empleado: " + e.getMessage());
            try { conn.rollback(); } catch (SQLException ex) {}
        }
    }

    private static void mostrarEmpleados(Connection conn) {
        String sql = "SELECT * FROM empleados";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- LISTA DE EMPLEADOS ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Nombre: " + rs.getString("nombre") +
                        " | Cargo: " + rs.getString("cargo") +
                        " | Salario: " + rs.getDouble("salario") +
                        " | Edad: " + rs.getInt("edad"));
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar empleados: " + e.getMessage());
        }
    }

    private static void actualizarEmpleado(Connection conn, Scanner sc) {
        try {
            conn.setAutoCommit(false);

            System.out.print("Ingrese el ID del empleado a actualizar: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nuevo cargo: ");
            String cargo = sc.nextLine();
            System.out.print("Nuevo salario: ");
            double salario = sc.nextDouble();
            System.out.print("Nueva edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            if (!verificarClave(sc)) {
                System.out.println("Clave incorrecta. Operación cancelada.");
                conn.rollback();
                return;
            }

            String sql = "UPDATE empleados SET nombre=?, cargo=?, salario=?, edad=? WHERE id=?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, cargo);
                pstmt.setDouble(3, salario);
                pstmt.setInt(4, edad);
                pstmt.setInt(5, id);
                int filas = pstmt.executeUpdate();

                if (filas > 0) {
                    conn.commit();
                    System.out.println("Empleado actualizado correctamente.");
                } else {
                    System.out.println("Empleado no encontrado.");
                    conn.rollback();
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            try { conn.rollback(); } catch (SQLException ex) {}
        }
    }

    private static void eliminarEmpleado(Connection conn, Scanner sc) {
        try {
            conn.setAutoCommit(false);

            System.out.print("Ingrese el ID del empleado a eliminar: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (!verificarClave(sc)) {
                System.out.println("Clave incorrecta. Operación cancelada.");
                conn.rollback();
                return;
            }

            String sql = "DELETE FROM empleados WHERE id=?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                int filas = pstmt.executeUpdate();

                if (filas > 0) {
                    conn.commit();
                    System.out.println("Empleado eliminado correctamente.");
                } else {
                    System.out.println("Empleado no encontrado.");
                    conn.rollback();
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            try { conn.rollback(); } catch (SQLException ex) {}
        }
    }
}



