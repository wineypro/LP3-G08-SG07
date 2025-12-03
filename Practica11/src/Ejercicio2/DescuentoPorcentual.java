package Ejercicio2;

public class DescuentoPorcentual implements EstrategiaDescuento {

    @Override
    public double calcularDescuento(Producto producto) {
        if (producto.getCantidad() == 2) {
            return producto.getPrecio() * 2 * 0.30;
        }
        return 0;
    }
}
