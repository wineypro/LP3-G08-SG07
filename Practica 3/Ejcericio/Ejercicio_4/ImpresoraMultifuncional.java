package Ejercicio_4;

class ImpresoraMultifuncional implements Imprimible, Escaneable {
    @Override
    public void imprimir(String documento) {
        System.out.println("Multifuncional imprime: " + documento);
    }

    @Override
    public void escanear(String documento) {
        System.out.println("Multifuncional escanea: " + documento);
    }
}
