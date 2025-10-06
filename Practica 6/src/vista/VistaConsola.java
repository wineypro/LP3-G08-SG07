package vista;

import modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaConsola {
    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Eliminar producto del carrito");
        System.out.println("5. Aplicar descuento");
        System.out.println("6. Calcular envío");
        System.out.println("7. Realizar compra");
        System.out.println("8. Ver historial de compras");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        return sc.nextInt();
    }

    public int leerIdProducto() {
        System.out.print("Ingrese ID del producto: ");
        return sc.nextInt();
    }

    public int leerCantidad() {
        System.out.print("Ingrese cantidad: ");
        return sc.nextInt();
    }

    public double leerDescuento() {
        System.out.print("Ingrese porcentaje de descuento: ");
        return sc.nextDouble();
    }

    public void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("\n--- Productos disponibles ---");
        for (Producto p : productos) System.out.println(p);
    }

    public void mostrarCarrito(ArrayList<ItemCarrito> items) {
        if (items.isEmpty()) System.out.println("El carrito está vacío.");
        else {
            System.out.println("\n--- Carrito actual ---");
            for (ItemCarrito item : items) System.out.println(item);
        }
    }

    public void mostrarHistorial(ArrayList<String> compras) {
        if (compras.isEmpty()) System.out.println("No hay compras registradas.");
        else {
            System.out.println("\n--- Historial de compras ---");
            for (String c : compras) System.out.println(c);
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}

