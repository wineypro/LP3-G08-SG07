package controlador;

import modelo.Empleado;
import java.io.*;
import java.util.*;

public class ControladorEmpleado {
    private final String archivo = "empleados.txt";
    private final List<Empleado> empleados = new ArrayList<>();

    public ControladorEmpleado() {
        leerEmpleados();
    }

    public void leerEmpleados() {
        empleados.clear();
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    int numero = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    double sueldo = Double.parseDouble(datos[2]);
                    empleados.add(new Empleado(numero, nombre, sueldo));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void guardarEmpleados() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            for (Empleado e : empleados) {
                pw.println(e.getNumero() + "," + e.getNombre() + "," + e.getSueldo());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<Empleado> listarEmpleados() {
        return empleados;
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
        guardarEmpleados();
        System.out.println("Empleado agregado correctamente.");
    }

    public Empleado buscarEmpleado(int numero) {
        for (Empleado e : empleados) {
            if (e.getNumero() == numero) {
                return e;
            }
        }
        return null;
    }

    public void eliminarEmpleado(int numero) {
        Empleado e = buscarEmpleado(numero);
        if (e != null) {
            empleados.remove(e);
            guardarEmpleados();
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
}

