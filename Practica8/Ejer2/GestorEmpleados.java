package Ejer2;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class GestorEmpleados {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public GestorEmpleados(Connection conn) {
        cargarEmpleados(conn);
    }

    private void cargarEmpleados(Connection conn) {
        empleados.clear();
        String sql = "SELECT * FROM empleados";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                empleados.add(new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("cargo"),
                        rs.getDouble("salario"),
                        rs.getInt("edad")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar empleados: " + e.getMessage());
        }
    }

    public void consultar(Scanner sc) {
        System.out.println("\n=== CONSULTA PERSONALIZADA ===");

        System.out.print("Ingrese los campos a mostrar (id,nombre,cargo,salario,edad o * para todos): ");
        String campos = sc.nextLine().trim();

        System.out.print("¿Desea aplicar una condición? (ejemplo: salario>2000 and edad<30 o Enter para omitir): ");
        String condicion = sc.nextLine().trim();

        System.out.print("¿Desea ordenar los resultados? (s/n): ");
        String ordenar = sc.nextLine().trim().toLowerCase();

        String campoOrden = "";
        String orden = "asc";

        if (ordenar.equals("s")) {
            if (campos.equals("*")) {
                System.out.print("¿Según qué campo desea ordenar? (id, nombre, cargo, salario, edad): ");
                campoOrden = sc.nextLine().trim();
            } else {
                campoOrden = campos.split(",")[0].trim();
                System.out.println("Se ordenará automáticamente según el campo '" + campoOrden + "'");
            }
            System.out.print("Orden ascendente o descendente (asc/desc): ");
            orden = sc.nextLine().trim().toLowerCase();
        }

        System.out.print("¿Desea limitar la cantidad de registros? (número o Enter para sin límite): ");
        String limiteStr = sc.nextLine().trim();
        int limite = limiteStr.isEmpty() ? -1 : Integer.parseInt(limiteStr);

        List<Empleado> resultado = new ArrayList<>(empleados);

        // Aplicar condición (soporta múltiples con and / or)
        if (!condicion.isEmpty()) {
            resultado = resultado.stream()
                    .filter(e -> cumpleCondiciones(e, condicion))
                    .collect(Collectors.toList());
        }

        // Ordenar
        if (!campoOrden.isEmpty()) {
            Comparator<Empleado> comp = getComparator(campoOrden);
            if (comp != null) {
                if (orden.equals("desc")) comp = comp.reversed();
                resultado.sort(comp);
            }
        }

        // Limitar resultados
        if (limite > 0 && limite < resultado.size()) {
            resultado = resultado.subList(0, limite);
        }

        // Mostrar resultados
        System.out.println("\n--- RESULTADOS ---");
        for (Empleado e : resultado) {
            mostrarCampos(e, campos);
        }
    }

    // Admite múltiples condiciones con 'and' y 'or'
    private boolean cumpleCondiciones(Empleado e, String condicion) {
        String[] partesOr = condicion.toLowerCase().split("\\s+or\\s+");
        for (String parteOr : partesOr) {
            String[] partesAnd = parteOr.trim().split("\\s+and\\s+");
            boolean cumpleAnd = true;
            for (String cond : partesAnd) {
                if (!cumpleCondicionSimple(e, cond.trim())) {
                    cumpleAnd = false;
                    break;
                }
            }
            if (cumpleAnd) return true; // si se cumple una parte del OR, ya es true
        }
        return false;
    }

    private boolean cumpleCondicionSimple(Empleado e, String condicion) {
        try {
            String campo = condicion.replaceAll("[<>]=?|==|!=", " ").trim().split(" ")[0];
            String operador = condicion.replaceAll("[a-zA-Z]", "").trim().split(" ")[0];
            String valor = condicion.replaceAll(".*[><=!]=?|.*==|.*!=", "").trim();

            switch (campo) {
                case "edad":
                    return comparar(e.edad, operador, Integer.parseInt(valor));
                case "salario":
                    return comparar(e.salario, operador, Double.parseDouble(valor));
                case "nombre":
                    return comparar(e.nombre, operador, valor);
                case "cargo":
                    return comparar(e.cargo, operador, valor);
                case "id":
                    return comparar(e.id, operador, Integer.parseInt(valor));
                default:
                    return false;
            }
        } catch (Exception ex) {
            System.out.println("Condición inválida: " + condicion);
            return false;
        }
    }

    private boolean comparar(Object a, String operador, Object b) {
        if (a instanceof Number && b instanceof Number) {
            double x = ((Number) a).doubleValue();
            double y = ((Number) b).doubleValue();
            return switch (operador) {
                case ">" -> x > y;
                case "<" -> x < y;
                case ">=" -> x >= y;
                case "<=" -> x <= y;
                case "==" -> x == y;
                case "!=" -> x != y;
                default -> false;
            };
        } else {
            String s1 = a.toString().toLowerCase();
            String s2 = b.toString().toLowerCase();
            return switch (operador) {
                case "==" -> s1.equals(s2);
                case "!=" -> !s1.equals(s2);
                default -> false;
            };
        }
    }

    private Comparator<Empleado> getComparator(String campo) {
        return switch (campo) {
            case "id" -> Comparator.comparingInt(e -> e.id);
            case "nombre" -> Comparator.comparing(e -> e.nombre);
            case "cargo" -> Comparator.comparing(e -> e.cargo);
            case "salario" -> Comparator.comparingDouble(e -> e.salario);
            case "edad" -> Comparator.comparingInt(e -> e.edad);
            default -> null;
        };
    }

    private void mostrarCampos(Empleado e, String campos) {
        if (campos.equals("*")) {
            System.out.println("ID: " + e.id + " | Nombre: " + e.nombre + " | Cargo: " + e.cargo +
                    " | Salario: " + e.salario + " | Edad: " + e.edad);
        } else {
            String[] lista = campos.split(",");
            StringBuilder salida = new StringBuilder();
            for (String c : lista) {
                c = c.trim();
                switch (c) {
                    case "id" -> salida.append("ID: ").append(e.id).append(" ");
                    case "nombre" -> salida.append("Nombre: ").append(e.nombre).append(" ");
                    case "cargo" -> salida.append("Cargo: ").append(e.cargo).append(" ");
                    case "salario" -> salida.append("Salario: ").append(e.salario).append(" ");
                    case "edad" -> salida.append("Edad: ").append(e.edad).append(" ");
                }
            }
            System.out.println(salida);
        }
    }
}

