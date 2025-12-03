package Ejercicio4;

public class Pedido {
    double monto;
    boolean confirmado;
    boolean cancelado;

    public Pedido(double monto) {
        this.monto = monto;
        this.confirmado = false;
        this.cancelado = false;
    }

    public void confirmar() {
        confirmado = true;
    }

    public void cancelar() {
        cancelado = true;
    }

    public void aplicarDescuento(EstrategiaDescuento e) {
        monto = e.aplicar(monto);
    }

    public String resumen() {
        return "Monto final: " + monto + " | Confirmado: " + confirmado + " | Cancelado: " + cancelado;
    }
}
