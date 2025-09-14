package Ejercicio3;

class Numero {
    private double valor;

    public Numero() {
        this.valor = 0;
    }

    public Numero(double valor) {
        setValor(valor);
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Error: No se permiten valores negativos. Valor ingresado: " + valor);
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}