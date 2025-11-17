package examenlp3.vista;

import examenlp3.controlador.ControladorInventario;
import examenlp3.modelo.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private final ControladorInventario ctrl;
    private final Scanner sc = new Scanner(System.in);

    public VistaConsola(ControladorInventario ctrl) {
        this.ctrl = ctrl;
    }

    public void iniciar() {
        int op;
        do {
            System.out.println("\n=== GESTIÓN DE MANTENIMIENTOS ===");
            System.out.println("1) Registrar asociación (Equipo + Mantenimiento)");
            System.out.println("2) Listar asociaciones");
            System.out.println("3) Guardar en archivo");
            System.out.println("4) Cargar desde archivo");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            op = leerInt();

            switch (op) {
                case 1 -> registrar();
                case 2 -> listar();
                case 3 -> System.out.println(ctrl.guardarArchivo() ? "Guardado OK" : "Error al guardar");
                case 4 -> System.out.println(ctrl.cargarArchivo() ? "Cargado OK" : "Error al cargar");
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }

    private void registrar() {
        System.out.println("\n-- Datos del Equipo --");
        System.out.print("ID Equipo: ");
        int idE = leerInt();
        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        System.out.print("Tipo: ");
        String tip = sc.nextLine();
        Equipo e = new Equipo(idE, nom, tip);

        System.out.println("\n-- Datos del Mantenimiento --");
        System.out.print("ID Mant.: ");
        int idM = leerInt();
        System.out.print("Descripción: ");
        String desc = sc.nextLine();
        System.out.print("Técnico: ");
        String tec = sc.nextLine();
        System.out.print("Fecha (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());
        System.out.print("Costo: ");
        double costo = Double.parseDouble(sc.nextLine());

        Mantenimiento m = new Mantenimiento(idM, desc, tec, fecha, costo);
        ctrl.registrarAsociacion(e, m);
        System.out.println("Asociación registrada.");
    }

    private void listar() {
        List<ParAsociado<Equipo, Mantenimiento>> list = ctrl.listarAsociaciones();
        if (list.isEmpty()) {
            System.out.println("No hay asociaciones.");
            return;
        }
        System.out.println("\n-- Listado --");
        for (ParAsociado<Equipo, Mantenimiento> par : list) {
            System.out.println(par);
        }
    }

    private int leerInt() {
        while (true) {
            try { 
                int val = Integer.parseInt(sc.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Intente de nuevo: ");
            }
        }
    }
}