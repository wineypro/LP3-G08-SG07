package modelo;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item armaEquipada;

    public Jugador(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = 100 + (nivel - 1) * 20;
        this.inventario = new InventarioModel();
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public InventarioModel getInventario() { return inventario; }
    public Item getArmaEquipada() { return armaEquipada; }

    public boolean equiparArma(String nombreArma) {
        Item item = inventario.buscarItem(nombreArma);
        if (item != null && item.getTipo().equalsIgnoreCase("Arma") && item.getCantidad() > 0) {
            armaEquipada = item;
            return true;
        }
        return false;
    }

    public int usarPocion(String nombrePocion) {
        Item pocion = inventario.buscarItem(nombrePocion);
        if (pocion != null && pocion.getTipo().equalsIgnoreCase("Pocion") && pocion.getCantidad() > 0) {
            int poder = pocion.getPoder();
            boolean usado = pocion.usarItem();
            if (usado) {
                int maxSalud = 100 + (nivel - 1) * 20;
                salud += poder;
                if (salud > maxSalud) salud = maxSalud;
                return poder;
            }
        }
        return 0;
    }

    public int atacar(Enemigo enemigo) {
        int base = (armaEquipada != null) ? armaEquipada.getPoder() : 5;
        int daño = base + nivel * 2;
        enemigo.recibirDaño(daño);
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


