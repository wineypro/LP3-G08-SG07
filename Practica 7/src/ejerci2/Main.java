package ejerci2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (true) {
            gestor.crearArchivoSiNoExiste();
            System.out.println("\n===== GESTOR DE PERSONAJES =====");
            System.out.println("1. Mostrar personajes");
            System.out.println("2. Agregar personaje");
            System.out.println("3. Modificar atributo de un personaje");
            System.out.println("4. Eliminar personaje");
            System.out.println("5. Filtrar personajes por atributo");
            System.out.println("6. Cargar personajes aleatorios");
            System.out.println("7. Mostrar estadísticas");
            System.out.println("8. Subir de nivel un personaje");
            System.out.println("9. Importar personajes desde archivo");
            System.out.println("10. Salir");
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
                    int nivel = leerEntero(sc, "Nivel inicial: ");
                    gestor.agregarPersonaje(new Personaje(nombre, vida, ataque, defensa, alcance, nivel));
                    break;

                case 3:
                    System.out.print("Nombre del personaje a modificar: ");
                    String nomMod = sc.nextLine();
                    System.out.print("Atributo a modificar (vida, ataque, defensa, alcance): ");
                    String atributo = sc.nextLine();
                    int nuevoValor = leerEntero(sc, "Nuevo valor: ");
                    gestor.modificarAtributo(nomMod, atributo, nuevoValor);
                    break;

                case 4:
                    System.out.print("Nombre del personaje a eliminar: ");
                    String nomDel = sc.nextLine();
                    gestor.eliminarPersonaje(nomDel);
                    break;

                case 5:
                    System.out.print("Atributo para filtrar (vida, ataque, defensa, alcance, nivel): ");
                    String atr = sc.nextLine();
                    gestor.filtrarPor(atr);
                    break;

                case 6:
                    gestor.cargarAleatorios();
                    break;

                case 7:
                    gestor.mostrarEstadisticas();
                    break;

                case 8:
                    System.out.print("Nombre del personaje a subir de nivel: ");
                    String nomSubir = sc.nextLine();
                    gestor.subirNivel(nomSubir);
                    break;

                case 9:
                    System.out.print("Ruta del archivo externo: ");
                    String ruta = sc.nextLine();
                    gestor.importarDesdeArchivo(ruta);
                    break;

                case 10:
                    System.out.println("Saliendo del programa...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }
        }
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = sc.nextInt();
                sc.nextLine();
                if (valor > 0) return valor;
                System.out.println("Debe ingresar un número mayor que cero.");
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                sc.nextLine();
            }
        }
    }
}
