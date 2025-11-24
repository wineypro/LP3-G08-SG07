package Ejercicio1;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "<html>Producto actualizado:<br>" +
               "Nombre: " + nombre + "<br>" +
               "Precio: S/ " + precio + "<br>" +
               "Cantidad en stock: " + cantidadStock + "<br>" +
               "Categoría: " + categoria + "</html>";
    }
}
