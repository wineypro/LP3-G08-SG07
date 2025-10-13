package ejerci2;

import java.io.*;
import java.util.*;

public class Gestor {
    private final String archivo = "personajes.txt";
    private List<Personaje> personajes = new ArrayList<>();
    private Random random = new Random();

    public Gestor() {
        crearArchivoSiNoExiste();
        cargarPersonajes();
    }

    public void crearArchivoSiNoExiste() {
        try {
            File file = new File(archivo);
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    private void guardarPersonajes() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes) {
                bw.write(p.getNombre() + "," + p.getVida() + "," + p.getAtaque() + "," +
                         p.getDefensa() + "," + p.getAlcance() + "," + p.getNivel());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los personajes: " + e.getMessage());
        }
    }

    private void cargarPersonajes() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 6) {
                    String nombre = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    int nivel = Integer.parseInt(datos[5]);
                    personajes.add(new Personaje(nombre, vida, ataque, defensa, alcance, nivel));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void agregarPersonaje(Personaje p) {
        for (Personaje per : personajes) {
            if (per.getNombre().equalsIgnoreCase(p.getNombre())) {
                System.out.println("El personaje ya existe.");
                return;
            }
        }
        personajes.add(p);
        guardarPersonajes();
        System.out.println("Personaje agregado correctamente.");
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        for (Personaje p : personajes) System.out.println(p);
    }

    public void eliminarPersonaje(String nombre) {
        Iterator<Personaje> it = personajes.iterator();
        boolean encontrado = false;
        while (it.hasNext()) {
            if (it.next().getNombre().equalsIgnoreCase(nombre)) {
                it.remove();
                encontrado = true;
            }
        }
        if (encontrado) {
            guardarPersonajes();
            System.out.println("Personaje eliminado correctamente.");
        } else System.out.println("Personaje no encontrado.");
    }

    public void modificarAtributo(String nombre, String atributo, int nuevoValor) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                switch (atributo.toLowerCase()) {
                    case "vida": p.setVida(nuevoValor); break;
                    case "ataque": p.setAtaque(nuevoValor); break;
                    case "defensa": p.setDefensa(nuevoValor); break;
                    case "alcance": p.setAlcance(nuevoValor); break;
                    default:
                        System.out.println("Atributo no válido.");
                        return;
                }
                guardarPersonajes();
                System.out.println("Atributo actualizado correctamente.");
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }

    public void filtrarPor(String atributo) {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes para mostrar.");
            return;
        }
        List<Personaje> ordenados = new ArrayList<>(personajes);
        ordenados.sort((a, b) -> {
            switch (atributo.toLowerCase()) {
                case "vida": return Integer.compare(b.getVida(), a.getVida());
                case "ataque": return Integer.compare(b.getAtaque(), a.getAtaque());
                case "defensa": return Integer.compare(b.getDefensa(), a.getDefensa());
                case "alcance": return Integer.compare(b.getAlcance(), a.getAlcance());
                case "nivel": return Integer.compare(b.getNivel(), a.getNivel());
                default: return 0;
            }
        });
        for (Personaje p : ordenados) System.out.println(p);
    }

    public void cargarAleatorios() {
        String[] clases = {"Caballero", "Guerrero", "Arquero", "Mago", "Asesino", "Hechicero", "Tanque", "Cazador"};
        String base = clases[random.nextInt(clases.length)];
        int numero = personajes.size() + 1;
        String nombre = base + "_" + numero;

        int vida = 2 + random.nextInt(9);
        int ataque = 2 + random.nextInt(9);
        int defensa = 1 + random.nextInt(9);
        int alcance = 1 + random.nextInt(10);
        int nivel = 1 + random.nextInt(3);

        Personaje nuevo = new Personaje(nombre, vida, ataque, defensa, alcance, nivel);
        personajes.add(nuevo);
        guardarPersonajes();
        System.out.println("Nuevo personaje aleatorio agregado:");
        System.out.println(nuevo);
    }

    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes para calcular estadísticas.");
            return;
        }
        double vidaProm = personajes.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double ataqueProm = personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double defensaProm = personajes.stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double alcanceProm = personajes.stream().mapToInt(Personaje::getAlcance).average().orElse(0);

        System.out.println("\n===== ESTADÍSTICAS =====");
        System.out.println("Total de personajes: " + personajes.size());
        System.out.printf("Vida promedio: %.2f%n", vidaProm);
        System.out.printf("Ataque promedio: %.2f%n", ataqueProm);
        System.out.printf("Defensa promedio: %.2f%n", defensaProm);
        System.out.printf("Alcance promedio: %.2f%n", alcanceProm);
    }

    public void importarDesdeArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 5) {
                    String nombre = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    int nivel = datos.length >= 6 ? Integer.parseInt(datos[5]) : 1;
                    agregarPersonaje(new Personaje(nombre, vida, ataque, defensa, alcance, nivel));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al importar personajes: " + e.getMessage());
        }
    }

    public void subirNivel(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.subirNivel();
                guardarPersonajes();
                System.out.println("El personaje ha subido de nivel. Nuevos atributos:");
                System.out.println(p);
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }
}


