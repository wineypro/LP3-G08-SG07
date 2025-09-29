package Ejercicio3;

public class Main {
    
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }
    
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Hola Mundo", 42);
        System.out.println("Par<String, Integer>:");
        imprimirPar(par1);
        
        Par<Double, Boolean> par2 = new Par<>(99.99, false);
        System.out.println("\nPar<Double, Boolean>:");
        imprimirPar(par2);
        
        Par<Persona, Integer> par3 = new Par<>(new Persona("María", 30), 1001);
        System.out.println("\nPar<Persona, Integer>:");
        imprimirPar(par3);
    }
}