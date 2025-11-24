package Ejercicio4;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMusica {

    private Clip clip;
    private Long posicionPausa = 0L;

    public void cargar(String archivo) {
        try {
            File soundFile = new File(archivo);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void reproducir() {
        if (clip == null) return;

        clip.stop();
        clip.setMicrosecondPosition(0);
        posicionPausa = 0L;
        clip.start();
    }

    public void pausar() {
        if (clip != null && clip.isRunning()) {
            posicionPausa = clip.getMicrosecondPosition();
            clip.stop();
        }
    }

    public void reanudar() {
        if (clip != null) {
            clip.setMicrosecondPosition(posicionPausa);
            clip.start();
        }
    }
}
