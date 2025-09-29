package Ejercicio1;

public class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }
    
    public F getPrimero() {
        return primero;
    }

    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public S getSegundo() {
        return segundo;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }

    public static void main(String[] args) {
        Par<Integer, String> par1 = new Par<>(1, "Uno");
        System.out.println(par1);

        Par<String, Double> par2 = new Par<>("Precio", 19.99);
        System.out.println(par2);

        par1.setPrimero(2);
        par1.setSegundo("Dos");
        System.out.println(par1);
    }
}
