package examenlp3.modelo;

import java.io.Serializable;

public class ParAsociado<T, U> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T primero;   // Equipo
    private U segundo;   // Mantenimiento

    public ParAsociado(T primero, U segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public T getPrimero() { return primero; }
    public U getSegundo() { return segundo; }

    @Override
    public String toString() {
        return primero.toString() + " -> " + segundo.toString();
    }
}