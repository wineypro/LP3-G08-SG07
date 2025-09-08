package Ejercicio_2;

public class Main {
	public static void main(String[] args) {
        Lienzo lienzo = new Lienzo();

        Dibujable circulo = new Circulo();
        Dibujable rectangulo = new Rectangulo();
        Dibujable triangulo = new Triangulo();

        lienzo.mostrar(circulo);
        lienzo.mostrar(rectangulo);
        lienzo.mostrar(triangulo);
    }
}
