package Ejercicio2;

public class DescuentoPorcentualAcumulado implements EstrategiaDescuento {

    @Override
    public double calcularDescuento(Producto producto) {
        if (producto.getCantidad() >= 3) {
            return producto.getPrecio() * 0.50;
        }
        return 0;
    }
}
