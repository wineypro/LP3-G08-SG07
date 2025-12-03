package Ejercicio4;

public class Descuento10 implements EstrategiaDescuento {
    public double aplicar(double monto) {
        return monto * 0.90;
    }
}
