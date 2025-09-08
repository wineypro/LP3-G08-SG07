package Ejercicio_4;

class Impresora implements Imprimible {
    @Override
    public void imprimir(String documento) {
        System.out.println("Imprimiendo: " + documento);
    }
}