package controlador;

import modelo.*;
import vista.*;

import java.util.ArrayList;

public class Controlador {
    private ArrayList<Producto> productos = new ArrayList<>();
    private Carrito carrito = new Carrito();
    private HistorialCompras historial = new HistorialCompras();
    private VistaConsola vista = new VistaConsola();

    public Controlador() {
        productos.add(new Producto(1, "Laptop", 2500));
        productos.add(new Producto(2, "Mouse", 50));
        productos.add(new Producto(3, "Teclado", 100));
        productos.add(new Producto(4, "Monitor", 800));
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    vista.mostrarProductos(productos);
                    break;
                case 2:
                    vista.mostrarProductos(productos);
                    int id = vista.leerIdProducto();
                    int cantidad = vista.leerCantidad();
                    Producto prod = buscarProducto(id);
                    if (prod != null) {
                        carrito.agregarProducto(prod, cantidad);
                        vista.mostrarMensaje("Producto agregado.");
                    } else vista.mostrarMensaje("Producto no encontrado.");
                    break;
                case 3:
                    vista.mostrarCarrito(carrito.getItems());
                    vista.mostrarMensaje("Total actual: $" + carrito.calcularTotal());
                    break;
                case 4:
                	if (carrito.getItems().isEmpty()) {
                		System.out.println("El carrito esta vacio");
                		break;
                		}
                    id = vista.leerIdProducto();
                    carrito.eliminarProducto(id);
                    vista.mostrarMensaje("Producto eliminado.");
                    break;
                case 5:
                	if (carrito.getItems().isEmpty()) {
                		System.out.println("El carrito esta vacio");
                		break;
                		}
                    double descuento = vista.leerDescuento();
                    carrito.aplicarDescuento(descuento);
                    vista.mostrarMensaje("Descuento aplicado.");
                    break;
                case 6:
                    vista.mostrarMensaje("Costo de envío: $" + carrito.calcularEnvio());
                    break;
                case 7:
                	if (carrito.getItems().isEmpty()) {
                		System.out.println("El carrito esta vacio");
                		break;
                		}
                    double total = carrito.calcularTotal() + carrito.calcularEnvio();
                    vista.mostrarMensaje("Compra realizada. Total a pagar: $" + total);
                    historial.registrarCompra("Compra por $" + total);
                    carrito.vaciar();
                    break;
                case 8:
                    vista.mostrarHistorial(historial.getCompras());
                    break;
                case 9:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 9);
    }

    private Producto buscarProducto(int id) {
        for (Producto p : productos) if (p.getId() == id) return p;
        return null;
    }
}
