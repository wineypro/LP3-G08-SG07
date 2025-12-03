package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class SistemaNotificaciones implements Subject {

    private List<Observer> usuarios = new ArrayList<>();

    @Override
    public void suscribir(Observer o) {
        usuarios.add(o);
        System.out.println("Usuario suscrito: " + ((Usuario)o).getNombre());
    }

    @Override
    public void desuscribir(Observer o) {
        usuarios.remove(o);
        System.out.println("Usuario desuscrito: " + ((Usuario)o).getNombre());
    }

    @Override
    public void notificar(Notificacion n) {
        for (Observer o : usuarios) {
            o.actualizar(n);
        }
    }

    public void mostrarSuscritos() {
        System.out.println("=== Usuarios Suscritos ===");
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios suscritos.");
        } else {
            for (Observer o : usuarios) {
                System.out.println(((Usuario)o).getNombre());
            }
        }
    }
}

