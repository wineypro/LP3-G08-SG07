package Ejercicio4;

public class TestContenedor {
    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor1 = new Contenedor<>();
        
        contenedor1.agregarPar("Manzanas", 10);
        contenedor1.agregarPar("Naranjas", 5);
        contenedor1.agregarPar("Peras", 8);
        
        System.out.println("=== Contenedor String-Integer ===");
        contenedor1.mostrarPares();
        
        System.out.println("\nPar en índice 1: " + contenedor1.obtenerPar(1));
        
        Contenedor<Double, Boolean> contenedor2 = new Contenedor<>();
        contenedor2.agregarPar(25.5, true);
        contenedor2.agregarPar(30.2, false);
        contenedor2.agregarPar(18.7, true);
        
        System.out.println("\n=== Contenedor Double-Boolean ===");
        contenedor2.mostrarPares();
        
        Contenedor<Persona, Integer> contenedor3 = new Contenedor<>();
        contenedor3.agregarPar(new Persona("Ana", 25), 1001);
        contenedor3.agregarPar(new Persona("Carlos", 30), 1002);
        contenedor3.agregarPar(new Persona("Laura", 28), 1003);
        
        System.out.println("\n=== Contenedor Persona-Integer ===");
        contenedor3.mostrarPares();
        
        System.out.println("\n=== Todos los pares del contenedor 3 ===");
        for (Par<Persona, Integer> par : contenedor3.obtenerTodosLosPares()) {
            System.out.println(par);
        }
        
        System.out.println("\nCantidad de pares en contenedor 1: " + contenedor1.cantidadPares());
        System.out.println("Cantidad de pares en contenedor 2: " + contenedor2.cantidadPares());
        System.out.println("Cantidad de pares en contenedor 3: " + contenedor3.cantidadPares());
    }
}