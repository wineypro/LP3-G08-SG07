package Ejercicio4;

public class Descuento20 implements EstrategiaDescuento {
    public double aplicar(double monto) {
        return monto * 0.80;
    }
}
