package Ejercicio2;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GraficoPanel extends JPanel {

    private double[] temperaturas;

    public GraficoPanel() {
        temperaturas = new double[7];
    }

    public void setTemperaturas(double[] temps) {
        this.temperaturas = temps;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int margen = 40;
        int ancho = getWidth();
        int alto = getHeight();

        int espacio = (ancho - 2 * margen) / 6;

        g.drawLine(margen, alto - margen, ancho - margen, alto - margen);
        g.drawLine(margen, margen, margen, alto - margen);

        int maxY = 50;
        int minY = -10;

        int[] x = new int[7];
        int[] y = new int[7];

        for (int i = 0; i < 7; i++) {

            x[i] = margen + i * espacio;

            double t = temperaturas[i];
            y[i] = (int) (alto - margen - (t - minY) * (alto - 2 * margen) / (maxY - minY));
        }

        g.setColor(Color.BLUE);
        for (int i = 0; i < 6; i++) {
            g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
        }

        g.setColor(Color.RED);
        for (int i = 0; i < 7; i++) {
            g.fillOval(x[i] - 4, y[i] - 4, 8, 8);
        }

        g.setColor(Color.BLACK);
        String[] dias = {"L", "M", "X", "J", "V", "S", "D"};
        for (int i = 0; i < 7; i++) {
            g.drawString(dias[i], x[i] - 5, alto - margen + 15);
        }
    }
}
