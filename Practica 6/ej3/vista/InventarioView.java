package vista;

import modelo.Item;
import java.util.List;

public class InventarioView {
    public void mostrarInventario(List<Item> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("Inventario vacío.");
            return;
        }
        System.out.println("\n--- Inventario ---");
        for (Item i : items) {
            System.out.println(i);
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}

