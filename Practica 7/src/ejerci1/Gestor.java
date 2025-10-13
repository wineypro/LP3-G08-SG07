package ejerci1;

import java.io.*;
import java.util.*;

public class Gestor {
    private List<Personaje> personajes;
    private final String archivo = "personajes.txt";

    public Gestor() {
        personajes = new ArrayList<>();
        leerArchivo();
    }

    private void leerArchivo() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String nombre = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    personajes.add(new Personaje(nombre, vida, ataque, defensa, alcance));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                pw.println(p.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo.");
        }
    }

    public void agregarPersonaje(Personaje p) {
        for (Personaje existente : personajes) {
            if (existente.getNombre().equalsIgnoreCase(p.getNombre())) {
                System.out.println("El personaje ya existe.");
                return;
            }
        }
        personajes.add(p);
        guardarArchivo();
        System.out.println("Personaje agregado correctamente.");
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    public void eliminarPersonaje(String nombre) {
        Iterator<Personaje> it = personajes.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                guardarArchivo();
                System.out.println("Personaje eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró el personaje.");
    }

    public void modificarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.setVida(vida);
                p.setAtaque(ataque);
                p.setDefensa(defensa);
                p.setAlcance(alcance);
                guardarArchivo();
                System.out.println("Personaje modificado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró el personaje.");
    }
}



