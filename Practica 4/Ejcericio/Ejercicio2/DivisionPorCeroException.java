package Ejercicio2;

class DivisionPorCeroException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public DivisionPorCeroException() {
        super("Error: División por cero no permitida");
    }
    
    public DivisionPorCeroException(String mensaje) {
        super(mensaje);
    }
}
