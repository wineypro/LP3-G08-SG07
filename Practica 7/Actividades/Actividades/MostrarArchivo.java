package Actividades;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MostrarArchivo extends JFrame {
    private JTextArea area;

    public MostrarArchivo() {
        setTitle("Visualizar Archivo de Texto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        area = new JTextArea();
        area.setFont(new Font("Consolas", Font.PLAIN, 14));
        area.setEditable(false);

        add(new JScrollPane(area), BorderLayout.CENTER);

        // Cambia aquí el archivo que deseas visualizar
        mostrarContenido("TestFile.java");
    }

    private void mostrarContenido(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            area.setText("❌ No se encontró el archivo: " + nombreArchivo);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                area.append(linea + "\n");
            }
        } catch (IOException e) {
            area.setText("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // 👇 Aquí el import era el problema, ahora se asegura que esté bien cargado
        javax.swing.SwingUtilities.invokeLater(() -> {
            new MostrarArchivo().setVisible(true);
        });
    }
}

