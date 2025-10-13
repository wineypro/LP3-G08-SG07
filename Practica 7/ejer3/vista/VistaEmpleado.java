package vista;

import modelo.Empleado;
import controlador.ControladorEmpleado;
import java.util.*;

public class VistaEmpleado {
    private final Scanner sc = new Scanner(System.in);
    private final ControladorEmpleado controlador = new ControladorEmpleado();

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE EMPLEADOS =====");
            System.out.println("1. Listar todos los empleados");
            System.out.println("2. Agregar nuevo empleado");
            System.out.println("3. Buscar empleado por número");
            System.out.println("4. Eliminar empleado por número");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> listar();
                case 2 -> agregar();
                case 3 -> buscar();
                case 4 -> eliminar();
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    private double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un valor numérico válido: ");
            }
        }
    }

    private void listar() {
        var lista = controlador.listarEmpleados();
        if (lista.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("\n--- LISTA DE EMPLEADOS ---");
            lista.forEach(System.out::println);
        }
    }

    private void agregar() {
        System.out.print("Número de empleado: ");
        int num = leerEntero();

        if (controlador.buscarEmpleado(num) != null) {
            System.out.println("Ya existe un empleado con ese número.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = leerDouble();

        controlador.agregarEmpleado(new Empleado(num, nombre, sueldo));
    }

    private void buscar() {
        System.out.print("Ingrese el número del empleado: ");
        int num = leerEntero();
        Empleado e = controlador.buscarEmpleado(num);

        if (e != null)
            System.out.println("Empleado encontrado: " + e);
        else
            System.out.println("Empleado no encontrado.");
    }

    private void eliminar() {
        System.out.print("Ingrese el número del empleado a eliminar: ");
        int num = leerEntero();
        controlador.eliminarEmpleado(num);
    }
}
