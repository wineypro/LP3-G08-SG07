package Ejercicio4;

public class AplicarDescuento implements Comando {
    Pedido p;
    EstrategiaDescuento e;

    public AplicarDescuento(Pedido p, EstrategiaDescuento e) {
        this.p = p;
        this.e = e;
    }

    public void ejecutar() {
        p.aplicarDescuento(e);
    }
}
