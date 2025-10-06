package modelo;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<ItemCarrito> items = new ArrayList<>();
    private double descuento = 0;

    public void agregarProducto(Producto producto, int cantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getId() == producto.getId()) {
                items.set(items.indexOf(item), new ItemCarrito(producto, item.getCantidad() + cantidad));
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad));
    }

    public void eliminarProducto(int id) {
        items.removeIf(item -> item.getProducto().getId() == id);
    }

    public ArrayList<ItemCarrito> getItems() {
        return items;
    }

    public void aplicarDescuento(double porcentaje) {
        this.descuento = porcentaje;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCarrito item : items) total += item.getSubtotal();
        if (descuento > 0) total -= total * (descuento / 100);
        return total;
    }

    public double calcularEnvio() {
        return (items.isEmpty()) ? 0 : 10;
    }

    public void vaciar() {
        items.clear();
        descuento = 0;
    }
}

