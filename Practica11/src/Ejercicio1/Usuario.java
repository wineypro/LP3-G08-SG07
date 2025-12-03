package Ejercicio1;

public class Usuario implements Observer {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Notificacion notificacion) {
        System.out.println("Notificación para " + nombre + ": " + notificacion.getMensaje());
    }

    public String getNombre() {
        return nombre;
    }
}

