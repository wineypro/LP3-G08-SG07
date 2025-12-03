package Ejercicio2;

public class CalculadoraDePrecios {

    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecioFinal(Producto producto) {
        double subtotal = producto.getPrecio() * producto.getCantidad();
        double descuento = estrategia.calcularDescuento(producto);
        return subtotal - descuento;
    }
}
