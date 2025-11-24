package Ejercicio1;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class VentanaProducto extends JFrame {

    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtCategoria;
    private JLabel lblResultado;

    private Producto producto;

    public VentanaProducto() {

        producto = new Producto("", 0, 0, "");

        setTitle("Gestión de Producto");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(5, 2, 5, 5));

        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelCampos.add(txtPrecio);

        panelCampos.add(new JLabel("Cantidad en stock:"));
        txtCantidad = new JTextField();
        panelCampos.add(txtCantidad);

        panelCampos.add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        panelCampos.add(txtCategoria);

        JButton btnActualizar = new JButton("Actualizar Producto");
        panelCampos.add(btnActualizar);

        add(panelCampos, BorderLayout.NORTH);

        lblResultado = new JLabel("La información del producto aparecerá aquí");
        lblResultado.setVerticalAlignment(SwingConstants.TOP);

        JPanel panelResultado = new JPanel();
        panelResultado.add(lblResultado);
        add(panelResultado, BorderLayout.CENTER);

        btnActualizar.addActionListener(e -> actualizarProducto());
    }

    private void actualizarProducto() {

        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();
        String cantidadStr = txtCantidad.getText().trim();
        String categoria = txtCategoria.getText().trim();

        if (nombre.isEmpty() || precioStr.isEmpty() || cantidadStr.isEmpty() || categoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.");
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(cantidadStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.");
            return;
        }

        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCantidadStock(cantidad);
        producto.setCategoria(categoria);

        lblResultado.setText(producto.toString());
    }
}
