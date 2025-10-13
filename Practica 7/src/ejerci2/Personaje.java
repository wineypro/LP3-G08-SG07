package ejerci2;

public class Personaje {
    private String nombre;
    private int vida, ataque, defensa, alcance, nivel;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance, int nivel) {
        this.nombre = nombre;
        this.vida = Math.max(1, vida);
        this.ataque = Math.max(1, ataque);
        this.defensa = Math.max(1, defensa);
        this.alcance = Math.max(1, alcance);
        this.nivel = Math.max(1, nivel);
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getAlcance() { return alcance; }
    public int getNivel() { return nivel; }

    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setAlcance(int alcance) { this.alcance = alcance; }

    public void subirNivel() {
        nivel++;
        vida += 2;
        ataque += 1;
        defensa += 1;
        alcance += 1;
    }

    @Override
    public String toString() {
        return nombre + " [Vida=" + vida + ", Ataque=" + ataque +
               ", Defensa=" + defensa + ", Alcance=" + alcance + ", Nivel=" + nivel + "]";
    }
}
