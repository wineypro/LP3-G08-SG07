package Ejercicio;

public class Profesor extends Persona {
    private String especialidad;

    public Profesor(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Profesor: " + nombre + " | Especialidad: " + especialidad);
    }
}
