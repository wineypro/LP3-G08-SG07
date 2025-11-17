package examenlp3.vista;

import examenlp3.controlador.ControladorInventario;
import examenlp3.modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class VistaGUI extends JFrame {

    private final ControladorInventario ctrl;
    private JTextField txtIdEq, txtNomEq, txtTipoEq;
    private JTextField txtIdMan, txtDesc, txtTec, txtFecha, txtCosto;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public VistaGUI(ControladorInventario ctrl) {
        super("Gestión de Mantenimientos (MVC)");
        this.ctrl = ctrl;
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // Panel formulario
        JPanel form = new JPanel(new GridLayout(2,1,8,8));
        form.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        // Form equipo
        JPanel pEq = new JPanel(new GridLayout(1,6,6,6));
        pEq.setBorder(BorderFactory.createTitledBorder("Equipo"));
        txtIdEq = new JTextField(); txtNomEq = new JTextField(); txtTipoEq = new JTextField();
        pEq.add(new JLabel("ID:")); pEq.add(txtIdEq);
        pEq.add(new JLabel("Nombre:")); pEq.add(txtNomEq);
        pEq.add(new JLabel("Tipo:")); pEq.add(txtTipoEq);

        // Form mantenimiento
        JPanel pMan = new JPanel(new GridLayout(2,6,6,6));
        pMan.setBorder(BorderFactory.createTitledBorder("Mantenimiento"));
        txtIdMan = new JTextField(); txtDesc = new JTextField(); txtTec = new JTextField();
        txtFecha = new JTextField("2025-11-16"); txtCosto = new JTextField("0");
        pMan.add(new JLabel("ID:"));      pMan.add(txtIdMan);
        pMan.add(new JLabel("Descripción:")); pMan.add(txtDesc);
        pMan.add(new JLabel("Técnico:")); pMan.add(txtTec);
        pMan.add(new JLabel("Fecha (YYYY-MM-DD):")); pMan.add(txtFecha);
        pMan.add(new JLabel("Costo:")); pMan.add(txtCosto);
        pMan.add(new JLabel()); pMan.add(new JLabel());

        form.add(pEq);
        form.add(pMan);
        add(form, BorderLayout.NORTH);

        // Tabla
        modeloTabla = new DefaultTableModel(
                new Object[]{"ID Eq", "Nombre", "Tipo", "ID Mant", "Descripción", "Técnico", "Fecha", "Costo"}, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Botonera
        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAgregar = new JButton("Registrar asociación");
        JButton btnListar  = new JButton("Refrescar lista");
        JButton btnGuardar = new JButton("Guardar archivo");
        JButton btnCargar  = new JButton("Cargar archivo");

        btnAgregar.addActionListener(e -> onAgregar());
        btnListar.addActionListener(e -> cargarTabla());
        btnGuardar.addActionListener(e -> {
            boolean ok = ctrl.guardarArchivo();
            JOptionPane.showMessageDialog(this, ok ? "Guardado OK" : "Error al guardar");
        });
        btnCargar.addActionListener(e -> {
            boolean ok = ctrl.cargarArchivo();
            JOptionPane.showMessageDialog(this, ok ? "Cargado OK" : "Error al cargar");
            if (ok) cargarTabla();
        });

        botones.add(btnAgregar);
        botones.add(btnListar);
        botones.add(btnGuardar);
        botones.add(btnCargar);

        add(botones, BorderLayout.SOUTH);

        setSize(950, 520);
        setLocationRelativeTo(null);
    }

    private void onAgregar() {
        try {
            int idE = Integer.parseInt(txtIdEq.getText().trim());
            String nom = txtNomEq.getText().trim();
            String tip = txtTipoEq.getText().trim();
            Equipo e = new Equipo(idE, nom, tip);

            int idM = Integer.parseInt(txtIdMan.getText().trim());
            String desc = txtDesc.getText().trim();
            String tec = txtTec.getText().trim();
            LocalDate fecha = LocalDate.parse(txtFecha.getText().trim());
            double costo = Double.parseDouble(txtCosto.getText().trim());
            Mantenimiento m = new Mantenimiento(idM, desc, tec, fecha, costo);

            ctrl.registrarAsociacion(e, m);
            cargarTabla();
            limpiarFormulario();
            JOptionPane.showMessageDialog(this, "Asociación registrada.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Datos inválidos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        List<ParAsociado<Equipo, Mantenimiento>> lista = ctrl.listarAsociaciones();
        for (ParAsociado<Equipo, Mantenimiento> par : lista) {
            Equipo e = par.getPrimero();
            Mantenimiento m = par.getSegundo();
            modeloTabla.addRow(new Object[]{
                    e.getId(), e.getNombre(), e.getTipo(),
                    m.getId(), m.getDescripcion(), m.getTecnico(),
                    m.getFecha(), m.getCosto()
            });
        }
    }

    private void limpiarFormulario() {
        txtIdEq.setText(""); txtNomEq.setText(""); txtTipoEq.setText("");
        txtIdMan.setText(""); txtDesc.setText(""); txtTec.setText("");
        txtFecha.setText("2025-11-16"); txtCosto.setText("0");
    }
}