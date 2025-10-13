package ejerci1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            System.out.println("\n===== GESTOR DE PERSONAJES =====");
            System.out.println("1. Mostrar personajes");
            System.out.println("2. Agregar personaje");
            System.out.println("3. Modificar personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    gestor.mostrarPersonajes();
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    int vida = leerEntero(sc, "Vida: ");
                    int ataque = leerEntero(sc, "Ataque: ");
                    int defensa = leerEntero(sc, "Defensa: ");
                    int alcance = leerEntero(sc, "Alcance: ");
                    try {
                        Personaje p = new Personaje(nombre, vida, ataque, defensa, alcance);
                        gestor.agregarPersonaje(p);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Nombre del personaje a modificar: ");
                    String nombreMod = sc.nextLine();
                    int nuevaVida = leerEntero(sc, "Nueva vida: ");
                    int nuevoAtaque = leerEntero(sc, "Nuevo ataque: ");
                    int nuevaDefensa = leerEntero(sc, "Nueva defensa: ");
                    int nuevoAlcance = leerEntero(sc, "Nuevo alcance: ");
                    gestor.modificarPersonaje(nombreMod, nuevaVida, nuevoAtaque, nuevaDefensa, nuevoAlcance);
                    break;
                case 4:
                    System.out.print("Nombre del personaje a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    gestor.eliminarPersonaje(nombreEliminar);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        int valor = 0;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = sc.nextInt();
                if (valor <= 0) {
                    System.out.println("Debe ser un número mayor que cero.");
                    continue;
                }
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
                sc.nextLine();
            }
        }
    }
}
