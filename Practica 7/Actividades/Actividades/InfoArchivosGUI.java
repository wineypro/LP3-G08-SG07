package Actividades;

import javax.swing.*;
import java.io.File;
import java.nio.file.*;
import java.io.IOException;

public class InfoArchivosGUI {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = chooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            Path path = archivo.toPath();

            StringBuilder sb = new StringBuilder();
            sb.append("Nombre: ").append(path.getFileName()).append("\n");
            sb.append("Ruta absoluta: ").append(path.toAbsolutePath()).append("\n");
            sb.append("¿Es directorio?: ").append(Files.isDirectory(path)).append("\n");
            try {
                sb.append("Tamaño: ").append(Files.size(path)).append(" bytes\n");
                sb.append("Última modificación: ").append(Files.getLastModifiedTime(path)).append("\n");
            } catch (IOException e) {
                sb.append("Error al obtener información.\n");
            }

            JTextArea area = new JTextArea(sb.toString());
            area.setEditable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane(area), "Información del Archivo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}
