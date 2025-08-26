package Ejercicio;

public abstract class Persona implements Mostrable {
    protected String nombre;
    protected String correo;

    public Persona(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public abstract void mostrarDatos();  // Polimorfismo
}

