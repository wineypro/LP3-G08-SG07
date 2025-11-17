package examenlp3.vista;

import examenlp3.controlador.ControladorInventario;

public class Main {
    public static void main(String[] args) {
        // Cambia el nombre del archivo si quieres
        ControladorInventario ctrl = new ControladorInventario("asociaciones.csv");

        // Opción 1: Consola
        // new VistaConsola(ctrl).iniciar();

        // Opción 2: GUI
        javax.swing.SwingUtilities.invokeLater(() -> new VistaGUI(ctrl).setVisible(true));
    }
}