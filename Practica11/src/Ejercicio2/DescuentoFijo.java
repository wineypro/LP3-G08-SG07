package Ejercicio2;

public class DescuentoFijo implements EstrategiaDescuento {
    @Override
    public double calcularDescuento(Producto producto) {
        return producto.getPrecio() * producto.getCantidad() * 0.10;
    }
}

