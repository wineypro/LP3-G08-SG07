package Ejercicio2;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class CompraPasajeFrame extends JFrame {

    private JTextField txtNombre, txtDocumento, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton piso1, piso2;
    private JComboBox<String> comboOrigen, comboDestino;
    private JList<String> listaCalidad;
    private JButton btnMostrar, btnLimpiar;

    @SuppressWarnings("unused")
	public CompraPasajeFrame() {
        super("Compra de Pasajes - Transporte Terrestre");

        // Layout principal
        setLayout(new BorderLayout(10, 10));

        // =============================
        // PANEL 1: Datos del pasajero
        // =============================
        JPanel panelDatos = new JPanel(new GridLayout(3, 2, 8, 8));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del pasajero"));

        txtNombre = new JTextField(20);
        txtDocumento = new JTextField(15);
        txtFecha = new JTextField(10);

        panelDatos.add(new JLabel("Nombre del pasajero:"));
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Documento de identidad:"));
        panelDatos.add(txtDocumento);

        panelDatos.add(new JLabel("Fecha del viaje (dd/mm/aaaa):"));
        panelDatos.add(txtFecha);


        // =============================
        // PANEL 2: Servicios Opcionales
        // =============================
        JPanel panelServicios = new JPanel(new GridLayout(1, 3));
        panelServicios.setBorder(BorderFactory.createTitledBorder("Servicios opcionales"));

        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");

        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);


        // =============================
        // PANEL 3: Selección de piso
        // =============================
        JPanel panelPiso = new JPanel(new GridLayout(1, 2));
        panelPiso.setBorder(BorderFactory.createTitledBorder("Piso"));

        piso1 = new JRadioButton("1er Piso");
        piso2 = new JRadioButton("2do Piso");

        ButtonGroup grupoPisos = new ButtonGroup();
        grupoPisos.add(piso1);
        grupoPisos.add(piso2);

        panelPiso.add(piso1);
        panelPiso.add(piso2);


        // =============================
        // PANEL 4: Origen y destino
        // =============================
        JPanel panelRuta = new JPanel(new GridLayout(2, 2, 8, 8));
        panelRuta.setBorder(BorderFactory.createTitledBorder("Ruta"));

        comboOrigen = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco", "Tacna"});
        comboDestino = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco", "Tacna"});

        panelRuta.add(new JLabel("Lugar de Origen:"));
        panelRuta.add(comboOrigen);

        panelRuta.add(new JLabel("Lugar de Destino:"));
        panelRuta.add(comboDestino);


        // =============================
        // PANEL 5: Calidad del servicio
        // =============================
        JPanel panelCalidad = new JPanel(new BorderLayout());
        panelCalidad.setBorder(BorderFactory.createTitledBorder("Calidad del servicio"));

        listaCalidad = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        listaCalidad.setVisibleRowCount(3);

        panelCalidad.add(new JScrollPane(listaCalidad), BorderLayout.CENTER);


        // =============================
        // PANEL 6: Botones
        // =============================
        JPanel panelBotones = new JPanel(new FlowLayout());

        btnMostrar = new JButton("Mostrar Resumen");
        btnLimpiar = new JButton("Limpiar");

        panelBotones.add(btnMostrar);
        panelBotones.add(btnLimpiar);


        // =============================
        // AGREGAR 
        // =============================
        add(panelDatos, BorderLayout.NORTH);
        add(panelServicios, BorderLayout.WEST);
        add(panelPiso, BorderLayout.EAST);
        add(panelRuta, BorderLayout.CENTER);
        add(panelCalidad, BorderLayout.SOUTH);

        // Debajo del panel calidad van los botones
        JPanel panelSur = new JPanel(new BorderLayout());
        panelSur.add(panelCalidad, BorderLayout.CENTER);
        panelSur.add(panelBotones, BorderLayout.SOUTH);

        add(panelSur, BorderLayout.SOUTH);


        // =============================
        // EVENTOS
        // =============================
        btnMostrar.addActionListener(e -> validarYMostrar());
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }


    private void validarYMostrar() {

        // Validaciones — mismas que ya te puse antes
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre.");
            return;
        }

        if (txtDocumento.getText().trim().isEmpty() || !txtDocumento.getText().trim().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Documento inválido.");
            return;
        }

        if (!txtFecha.getText().trim().matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto.");
            return;
        }

        if (!piso1.isSelected() && !piso2.isSelected()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un piso.");
            return;
        }

        if (comboOrigen.getSelectedItem().equals(comboDestino.getSelectedItem())) {
            JOptionPane.showMessageDialog(this, "Origen y destino no pueden ser iguales.");
            return;
        }

        if (listaCalidad.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir la calidad del servicio.");
            return;
        }

        String servicios = "";
        if (chkAudifonos.isSelected()) servicios += "Audífonos ";
        if (chkManta.isSelected()) servicios += "Manta ";
        if (chkRevistas.isSelected()) servicios += "Revistas ";
        if (servicios.isEmpty()) servicios = "Ninguno";

        String piso = piso1.isSelected() ? "1er Piso" : "2do Piso";

        String resumen =
                "=== RESUMEN DEL PASAJE ===\n\n" +
                "Nombre: " + txtNombre.getText() + "\n" +
                "Documento: " + txtDocumento.getText() + "\n" +
                "Fecha: " + txtFecha.getText() + "\n" +
                "Servicios: " + servicios + "\n" +
                "Piso: " + piso + "\n" +
                "Origen: " + comboOrigen.getSelectedItem() + "\n" +
                "Destino: " + comboDestino.getSelectedItem() + "\n" +
                "Calidad: " + listaCalidad.getSelectedValue();

        JOptionPane.showMessageDialog(this, resumen, "Resumen del Pasaje", JOptionPane.INFORMATION_MESSAGE);
    }


    private void limpiarCampos() {
        txtNombre.setText("");
        txtDocumento.setText("");
        txtFecha.setText("");

        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);

        piso1.setSelected(false);
        piso2.setSelected(false);

        comboOrigen.setSelectedIndex(0);
        comboDestino.setSelectedIndex(0);

        listaCalidad.clearSelection();
    }
}

