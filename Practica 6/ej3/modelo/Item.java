package modelo;

public class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;
    private int poder;

    public Item(String nombre, int cantidad, String tipo, String descripcion, int poder) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.poder = poder;
    }

    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public int getPoder() { return poder; }

    public boolean usarItem() {
        if (cantidad > 0) {
            cantidad--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Poder: " + poder + " - Cantidad: " + cantidad;
    }
}


