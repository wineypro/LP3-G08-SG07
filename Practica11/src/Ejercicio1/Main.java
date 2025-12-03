package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaNotificaciones sistema = new SistemaNotificaciones();
        List<Usuario> usuariosRegistrados = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Suscribir usuario");
            System.out.println("3. Desuscribir usuario");
            System.out.println("4. Enviar notificación");
            System.out.println("5. Mostrar usuarios suscritos");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();  

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese nombre del usuario: ");
                    String nombre = sc.nextLine();
                    Usuario u = new Usuario(nombre);
                    usuariosRegistrados.add(u);
                    System.out.println("Usuario registrado correctamente.");
                    break;

                case 2:
                    System.out.print("Nombre del usuario a suscribir: ");
                    nombre = sc.nextLine();
                    Usuario sus = buscarUsuario(nombre, usuariosRegistrados);
                    if (sus != null) {
                        sistema.suscribir(sus);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre del usuario a desuscribir: ");
                    nombre = sc.nextLine();
                    Usuario des = buscarUsuario(nombre, usuariosRegistrados);
                    if (des != null) {
                        sistema.desuscribir(des);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Mensaje de la notificación: ");
                    String mensaje = sc.nextLine();
                    sistema.notificar(new Notificacion(mensaje));
                    break;

                case 5:
                    sistema.mostrarSuscritos();
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }

    private static Usuario buscarUsuario(String nombre, List<Usuario> lista) {
        for (Usuario u : lista) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                return u;
            }
        }
        return null;
    }
}

