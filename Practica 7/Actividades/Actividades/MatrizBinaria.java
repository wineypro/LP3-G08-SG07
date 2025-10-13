package Actividades;

import java.io.*;
import java.util.Scanner;

public class MatrizBinaria {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese número de filas: ");
        int filas = sc.nextInt();
        System.out.print("Ingrese número de columnas: ");
        int cols = sc.nextInt();

        double[][] matriz = new double[filas][cols];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("matriz.dat"))) {
            out.writeInt(filas);
            out.writeInt(cols);
            for (double[] fila : matriz) {
                for (double v : fila) {
                    out.writeDouble(v);
                }
            }
            System.out.println("✅ Matriz guardada correctamente en matriz.dat");
        } catch (IOException e) {
            System.out.println("Error al escribir archivo binario: " + e.getMessage());
        }
    }
}
