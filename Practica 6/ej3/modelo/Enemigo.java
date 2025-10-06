package modelo;

import java.util.Random;

public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;
    private Random random = new Random();

    public Enemigo(String nombre, int nivel, String tipo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.tipo = tipo;
        this.salud = 50 + nivel * 20;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }

    public int atacar(Jugador jugador) {
        int daño = 5 + nivel * 2 + random.nextInt(6);
        jugador.recibirDaño(daño);
        return daño;
    }

    public void recibirDaño(int daño) {
        salud -= daño;
        if (salud < 0) salud = 0;
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}

