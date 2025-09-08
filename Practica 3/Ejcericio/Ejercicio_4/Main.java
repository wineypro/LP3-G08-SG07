package Ejercicio_4;

public class Main {
    public static void main(String[] args) {
        Imprimible impresora = new Impresora();
        Imprimible multifuncionalImpresion = new ImpresoraMultifuncional();
        Escaneable multifuncionalEscaneo = new ImpresoraMultifuncional();

        impresora.imprimir("Documento A");

        multifuncionalImpresion.imprimir("Documento B");

        multifuncionalEscaneo.escanear("Documento C");
    }
}

