package Ejercicio4;

public class ConfirmarPedido implements Comando {
    Pedido p;

    public ConfirmarPedido(Pedido p) {
        this.p = p;
    }

    public void ejecutar() {
        p.confirmar();
    }
}
