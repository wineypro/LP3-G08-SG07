package controlador;

import modelo.*;
import vista.*;
import java.util.Random;
import java.util.Scanner;

public class CombateController {
    private Jugador jugador;
    private Enemigo enemigo;
    private CombateView vista;
    private InventarioView vistaInventario = new InventarioView();
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    public CombateController(Jugador jugador, Enemigo enemigo, CombateView vista) {
        this.jugador = jugador;
        this.enemigo = enemigo;
        this.vista = vista;
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("\n¡Comienza el combate entre " + jugador.getNombre() + " y " + enemigo.getNombre() + "!");
        while (jugador.estaVivo() && enemigo.estaVivo()) {
            vista.mostrarEstado(jugador, enemigo);
            vista.mostrarOpciones();
            String line = sc.nextLine();
            int opcion;
            try {
                opcion = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                vista.mostrarMensaje("Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1:
                    int daño = jugador.atacar(enemigo);
                    vista.mostrarMensaje(jugador.getNombre() + " atacó a " + enemigo.getNombre() + " e infligió " + daño + " de daño.");
                    break;
                case 2:
                    vista.mostrarMensaje("Escribe el nombre de la poción a usar:");
                    String nombreP = sc.nextLine().trim();
                    int curado = jugador.usarPocion(nombreP);
                    if (curado > 0) vista.mostrarMensaje("Usaste " + nombreP + " y curaste " + curado + " puntos.");
                    else vista.mostrarMensaje("No tienes esa poción o no quedan unidades.");
                    break;
                case 3:
                    vista.mostrarMensaje("Escribe el nombre del arma a equipar:");
                    String nombreA = sc.nextLine().trim();
                    boolean ok = jugador.equiparArma(nombreA);
                    if (ok) vista.mostrarMensaje("Has equipado " + nombreA + ".");
                    else vista.mostrarMensaje("No tienes ese arma o no es equipable.");
                    break;
                case 4:
                    vistaInventario.mostrarInventario(jugador.getInventario().obtenerItems());
                    break;
                case 5:
                    vista.mostrarMensaje(jugador.getNombre() + " huyó del combate.");
                    return;
                default:
                    vista.mostrarMensaje("Acción inválida.");
            }

            if (!enemigo.estaVivo()) break;

            boolean enemigoActua = random.nextBoolean();
            if (enemigoActua) {
                int dañoEn = enemigo.atacar(jugador);
                vista.mostrarMensaje(enemigo.getNombre() + " ataca y causa " + dañoEn + " de daño a " + jugador.getNombre() + ".");
            } else {
                vista.mostrarMensaje(enemigo.getNombre() + " se prepara/espera.");
            }
        }

        if (jugador.estaVivo() && !enemigo.estaVivo()) {
            vista.mostrarMensaje("\n¡" + jugador.getNombre() + " ha derrotado a " + enemigo.getNombre() + "!");
        } else if (!jugador.estaVivo()) {
            vista.mostrarMensaje("\n" + enemigo.getNombre() + " ha derrotado a " + jugador.getNombre() + "...");
        }
    }
}



