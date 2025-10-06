package vista;

import modelo.Item;
import java.util.List;

public class InventarioView {
    public void mostrarInventario(List<Item> items) {
        System.out.println("\n--- Inventario ---");
        if (items.isEmpty()) {
            System.out.println("No hay ítems en el inventario.");
        } else {
            for (Item i : items) {
                System.out.println(i);
            }
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println("\nDetalles del ítem:");
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Descripción: " + item.getDescripcion());
        } else {
            System.out.println("Ítem no encontrado.");
        }
    }
}
