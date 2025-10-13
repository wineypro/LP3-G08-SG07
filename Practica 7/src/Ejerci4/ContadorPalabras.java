package Ejerci4;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ContadorPalabras {

    public static void main(String[] args) {
        File archivo = seleccionarArchivo();

        if (archivo == null) {
            System.out.println("No se seleccionó ningún archivo. El programa se cerrará.");
            return;
        }

        procesarArchivo(archivo);
    }

    private static File seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione un archivo de texto (.txt)");

        while (true) {
            int resultado = fileChooser.showOpenDialog(null);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                if (archivo.exists() && archivo.isFile()) {
                    return archivo;
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo inválido o inexistente. Intente nuevamente.");
                }
            } else {
                return null;
            }
        }
    }

    private static void procesarArchivo(File archivo) {
        int lineas = 0;
        int palabras = 0;
        int caracteres = 0;
        Map<String, Integer> frecuencia = new HashMap<>();

        Pattern patronPalabra = Pattern.compile("\\b[\\p{L}\\p{N}]+\\b"); // Letras o números

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.replace("\n", "").length();

                Matcher matcher = patronPalabra.matcher(linea);
                while (matcher.find()) {
                    String palabra = matcher.group().toLowerCase();
                    palabras++;
                    frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                }
            }

            mostrarResultados(lineas, palabras, caracteres, frecuencia);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void mostrarResultados(int lineas, int palabras, int caracteres, Map<String, Integer> frecuencia) {
        System.out.println("\n===== RESULTADOS DEL ARCHIVO =====");
        System.out.println("Total de líneas: " + lineas);
        System.out.println("Total de palabras: " + palabras);
        System.out.println("Total de caracteres (sin contar saltos de línea): " + caracteres);

        double promedio = (lineas > 0) ? (double) palabras / lineas : 0;
        System.out.printf("Promedio de palabras por línea: %.2f%n", promedio);

        System.out.println("\nPalabras más frecuentes:");
        frecuencia.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + " → " + e.getValue() + " veces"));
    }
}
