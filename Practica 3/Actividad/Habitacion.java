package Actividad;

//===== SRP: Clase Habitacion solo gestiona datos =====
public class Habitacion {
    private int numero;
    private double precio;
    private boolean disponible;

    public Habitacion(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
        this.disponible = true;
    }

    public int getNumero() { return numero; }
    public double getPrecio() { return precio; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}

// SRP: Gestor separado para disponibilidad
class GestorDisponibilidadHabitacion {
    public boolean verificarDisponibilidad(Habitacion habitacion) {
        return habitacion.isDisponible();
    }

    public void reservar(Habitacion habitacion) {
        habitacion.setDisponible(false);
    }

    public void liberar(Habitacion habitacion) {
        habitacion.setDisponible(true);
    }
}

// LSP: Subclases de tipo de habitación
abstract class TipoHabitacion extends Habitacion {
    public TipoHabitacion(int numero, double precio) {
        super(numero, precio);
    }
    public abstract String descripcion();
}

class Suite extends TipoHabitacion {
    public Suite(int numero, double precio) {
        super(numero, precio);
    }
    @Override
    public String descripcion() {
        return "Habitación tipo Suite con servicios premium.";
    }
}

class HabitacionSimple extends TipoHabitacion {
    public HabitacionSimple(int numero, double precio) {
        super(numero, precio);
    }
    @Override
    public String descripcion() {
        return "Habitación simple estándar.";
    }
}