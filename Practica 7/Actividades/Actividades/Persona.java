package Actividades;

import java.io.*;
import java.util.*;

class Persona {
    String nombre, telefono, direccion;

    public Persona(String nombre, String telefono, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombre + " - " + telefono + " - " + direccion;
    }
}

public class Agenda {
    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();

        try (Scanner sc = new Scanner(new File("agenda.txt"))) {
            while (sc.hasNextLine()) {
                String[] datos = sc.nextLine().split(",");
                if (datos.length == 3) {
                    personas.add(new Persona(datos[0], datos[1], datos[2]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo agenda.txt");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre a buscar: ");
        String nombreBuscado = sc.nextLine();

        boolean encontrado = false;
        for (Persona p : personas) {
            if (p.nombre.equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Encontrado: " + p);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No existe ese contacto.");
    }
}
