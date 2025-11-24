package Ejercicio2;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class VentanaTemperatura extends JFrame {

    private JTextField[] campos;
    private GraficoPanel panelGrafico;

    public VentanaTemperatura() {
        setTitle("Temperaturas Semanales");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelEntrada = new JPanel(new GridLayout(2, 7, 5, 5));

        String[] dias = {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
        campos = new JTextField[7];

        for (String d : dias) {
            panelEntrada.add(new JLabel(d, SwingConstants.CENTER));
        }

        for (int i = 0; i < 7; i++) {
            campos[i] = new JTextField();
            panelEntrada.add(campos[i]);
        }

        JButton btnMostrar = new JButton("Mostrar Gráfico");
        btnMostrar.addActionListener(e -> mostrarGrafico());

        add(panelEntrada, BorderLayout.NORTH);
        add(btnMostrar, BorderLayout.SOUTH);

        panelGrafico = new GraficoPanel();
        panelGrafico.setBackground(Color.WHITE);
        add(panelGrafico, BorderLayout.CENTER);
    }

    private void mostrarGrafico() {
        double[] temps = new double[7];

        for (int i = 0; i < 7; i++) {
            String texto = campos[i].getText().trim();
            try {
                temps[i] = Double.parseDouble(texto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingresa valores numéricos en todos los días.");
                return;
            }
        }

        panelGrafico.setTemperaturas(temps);
    }
}
