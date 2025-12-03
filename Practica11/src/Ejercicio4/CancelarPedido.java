package Ejercicio4;

public class CancelarPedido implements Comando {
    Pedido p;

    public CancelarPedido(Pedido p) {
        this.p = p;
    }

    public void ejecutar() {
        p.cancelar();
    }
}

