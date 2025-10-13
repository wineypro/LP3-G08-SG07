package Actividades;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class InfoArchivos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la ruta del archivo o directorio: ");
        String ruta = sc.nextLine();

        Path path = Paths.get(ruta);

        if (Files.exists(path)) {
            System.out.println("\n--- Información del archivo/directorio ---");
            System.out.println("Nombre: " + path.getFileName());
            System.out.println("Ruta absoluta: " + path.toAbsolutePath());
            System.out.println("¿Es directorio? " + Files.isDirectory(path));
            System.out.println("¿Ruta absoluta? " + path.isAbsolute());
            try {
                System.out.println("Última modificación: " + Files.getLastModifiedTime(path));
                System.out.println("Tamaño (bytes): " + Files.size(path));
            } catch (IOException e) {
                System.out.println("Error al obtener información: " + e.getMessage());
            }

            if (Files.isDirectory(path)) {
                System.out.println("\n--- Contenido del directorio ---");
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
                    for (Path p : stream) {
                        System.out.println(p.getFileName());
                    }
                } catch (IOException e) {
                    System.out.println("Error al listar directorio: " + e.getMessage());
                }
            }
        } else {
            System.out.println("El archivo o directorio no existe.");
        }
    }
}
