package Actividades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribirArchivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto;
        System.out.println("Escriba líneas de texto (fin con 'salir'):");

        try (FileWriter fw = new FileWriter("datos.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            while (true) {
                texto = sc.nextLine();
                if (texto.equalsIgnoreCase("salir")) break;
                pw.println(texto);
            }
            System.out.println(" Texto guardado correctamente en datos.txt");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
