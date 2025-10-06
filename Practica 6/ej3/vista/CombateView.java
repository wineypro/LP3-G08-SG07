package vista;

import modelo.Enemigo;
import modelo.Jugador;

public class CombateView {
    public void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n--- Estado del combate ---");
        System.out.println(jugador.getNombre() + " | Salud: " + jugador.getSalud() + " | Nivel: " + jugador.getNivel());
        System.out.println(enemigo.getNombre() + " | Salud: " + enemigo.getSalud() + " | Nivel: " + enemigo.getNivel());
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarOpciones() {
        System.out.println("\nOpciones:");
        System.out.println("1. Atacar");
        System.out.println("2. Usar poción");
        System.out.println("3. Equipar arma");
        System.out.println("4. Ver inventario");
        System.out.println("5. Huir");
        System.out.print("Elige acción: ");
    }
}


