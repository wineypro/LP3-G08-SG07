package Ejercicio4;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class VentanaMusica extends JFrame {

    private ReproductorMusica reproductor;

    @SuppressWarnings("unused")
	public VentanaMusica() {
        setTitle("Reproductor de Música");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3, 10, 10));

        reproductor = new ReproductorMusica();

        reproductor.cargar("musica.wav");

        JButton btnReproducir = new JButton("Reproducir");
        JButton btnPausar = new JButton("Pausar");
        JButton btnReanudar = new JButton("Reanudar");

        btnReproducir.addActionListener(e -> reproductor.reproducir());
        btnPausar.addActionListener(e -> reproductor.pausar());
        btnReanudar.addActionListener(e -> reproductor.reanudar());

        add(btnReproducir);
        add(btnPausar);
        add(btnReanudar);
    }
}
