package controlador;

import modelo.*;
import vista.*;

import java.util.Scanner;

public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;
    private Scanner sc = new Scanner(System.in);

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ DE INVENTARIO ===");
            System.out.println("1. Ver inventario");
            System.out.println("2. Agregar ítem");
            System.out.println("3. Eliminar ítem");
            System.out.println("4. Mostrar detalles de un ítem");
            System.out.println("5. Usar ítem");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    verInventario();
                    break;
                case 2:
                    agregarItem();
                    break;
                case 3:
                    eliminarItem();
                    break;
                case 4:
                    mostrarDetalles();
                    break;
                case 5:
                    usarItem();
                    break;
                case 6:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 6);
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void agregarItem() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        System.out.print("Tipo (Arma, Poción, etc.): ");
        String tipo = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        modelo.agregarItem(new Item(nombre, cantidad, tipo, descripcion));
        vista.mostrarMensaje("Ítem agregado correctamente.");
    }

    public void eliminarItem() {
        System.out.print("Ingrese el nombre del ítem a eliminar: ");
        String nombre = sc.nextLine();
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            modelo.eliminarItem(item);
            vista.mostrarMensaje("Ítem eliminado.");
        } else {
            vista.mostrarMensaje("Ítem no encontrado.");
        }
    }

    public void mostrarDetalles() {
        System.out.print("Ingrese el nombre del ítem: ");
        String nombre = sc.nextLine();
        Item item = modelo.buscarItem(nombre);
        vista.mostrarDetallesItem(item);
    }

    public void usarItem() {
        System.out.print("Ingrese el nombre del ítem a usar: ");
        String nombre = sc.nextLine();
        Item item = modelo.buscarItem(nombre);
        if (item != null) {
            item.usarItem();
        } else {
            vista.mostrarMensaje("Ítem no encontrado.");
        }
    }
}

