package Main;

import modelo.*;
import vista.*;
import controlador.*;

public class Main {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Héroe", 2);
        jugador.getInventario().agregarItem(new Item("Espada de Acero", 1, "Arma", "Espada afilada", 20));
        jugador.getInventario().agregarItem(new Item("Hacha Pesada", 1, "Arma", "Corta con fuerza", 25));
        jugador.getInventario().agregarItem(new Item("Poción Curativa", 3, "Pocion", "Recupera salud", 20));

        Enemigo enemigo = new Enemigo("Orco", 1, "Bestia");

        CombateView vista = new CombateView();
        CombateController combate = new CombateController(jugador, enemigo, vista);

        combate.iniciarCombate();
    }
}


