package Ejercicio3;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class VentanaSonidos extends JFrame {

    public VentanaSonidos() {

        setTitle("Reproductor de Sonidos");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1, 3, 10, 10));

        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana = new JButton("Campana");
        JButton btnExplosion = new JButton("Explosión");

        btnAplausos.addActionListener(e ->
                ReproductorSonido.reproducir("aplausos.wav")
        );

        btnCampana.addActionListener(e ->
                ReproductorSonido.reproducir("campana.wav")
        );

        btnExplosion.addActionListener(e ->
                ReproductorSonido.reproducir("explosion.wav")
        );

        add(btnAplausos);
        add(btnCampana);
        add(btnExplosion);
    }
}

