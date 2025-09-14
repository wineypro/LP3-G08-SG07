package Ejercicio4;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class MainRegistroEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroEstudiantes registro = new RegistroEstudiantes();
        
        System.out.println("REGISTRO DE ESTUDIANTES");
        System.out.println("=======================");

        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar estudiante por nombre");
            System.out.println("3. Mostrar todos los estudiantes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        agregarEstudiante(scanner, registro);
                        break;
                    case 2:
                        buscarEstudiante(scanner, registro);
                        break;
                    case 3:
                        registro.mostrarEstudiantes();
                        break;
                    case 4:
                        continuar = false;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("❌ Opción no válida");
                }
                
            } catch (java.util.InputMismatchException e) {
                System.out.println("❌ Error: Debe ingresar un número válido");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Error inesperado: " + e.getMessage());
            }
        }
        
        scanner.close();
    }

    private static void agregarEstudiante(Scanner scanner, RegistroEstudiantes registro) {
        try {
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese la edad del estudiante: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Ingrese el código del estudiante: ");
            String codigo = scanner.nextLine();
            
            Estudiante estudiante = new Estudiante(nombre, edad, codigo);
            registro.agregarEstudiante(estudiante);
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: La edad debe ser un número válido");
            scanner.nextLine();
        }
    }

    private static void buscarEstudiante(Scanner scanner, RegistroEstudiantes registro) {
        try {
            System.out.print("Ingrese el nombre del estudiante a buscar: ");
            String nombre = scanner.nextLine();
            
            Estudiante encontrado = registro.buscarEstudiante(nombre);
            System.out.println("Estudiante encontrado: " + encontrado);
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
