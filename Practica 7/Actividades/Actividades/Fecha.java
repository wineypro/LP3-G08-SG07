package Actividades;

import java.io.*;
import java.io.Serializable;

class Fecha implements Serializable {
    int dia, mes, anio;
    public Fecha(int d, int m, int a) {
        dia = d; mes = m; anio = a;
    }
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}

class Persona implements Serializable {
    String nombre;
    public Persona(String n) { nombre = n; }
    public String toString() { return "Nombre: " + nombre; }
}

class Alumno extends Persona {
    Fecha fechaNacimiento;
    public Alumno(String n, Fecha f) {
        super(n);
        this.fechaNacimiento = f;
    }
    public String toString() {
        return super.toString() + " | Fecha Nac: " + fechaNacimiento;
    }
}

public class SerializarAlumno {
    public static void main(String[] args) {
        Alumno[] alumnos = {
            new Alumno("Juan", new Fecha(1,1,2000)),
            new Alumno("Ana", new Fecha(15,5,2001)),
            new Alumno("Luis", new Fecha(10,8,2002))
        };

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("alumnos.dat"))) {
            for (Alumno a : alumnos) out.writeObject(a);
            System.out.println("✅ Objetos serializados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al serializar: " + e.getMessage());
        }

        System.out.println("\n--- Leyendo desde el archivo ---");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("alumnos.dat"))) {
            while (true) {
                Alumno a = (Alumno) in.readObject();
                System.out.println(a);
            }
        } catch (EOFException e) {
            System.out.println("Lectura completa.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
