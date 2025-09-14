package Ejercicio2;

class Calculadora {
    
    public double sumar(double a, double b) {
        return a + b;
    }
    
    public double restar(double a, double b) {
        return a - b;
    }
    
    public double multiplicar(double a, double b) {
        return a * b;
    }
    
    public double dividir(double a, double b) throws DivisionPorCeroException {
        if (b == 0) {
            throw new DivisionPorCeroException();
        }
        return a / b;
    }
}
