package Ejercicio;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private Profesor profesor;  // Agregación
    private Categoria categoria;  // Composición
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private static final int MAX_ESTUDIANTES_POR_CURSO = 30;
    private static int contadorCursos = 0;

    public Curso(String nombre, Profesor profesor, Categoria categoria) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.categoria = categoria;
        contadorCursos++;
    }

    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES_POR_CURSO) {
            estudiantes.add(estudiante);
            return true;
        } else {
            System.out.println("Cupo lleno en el curso " + nombre);
            return false;
        }
    }

    public void mostrarCurso() {
        System.out.println("Curso: " + nombre + " | Categoría: " + categoria.getNombre());
        System.out.println("Profesor a cargo:");
        profesor.mostrarDatos();
        System.out.println("Estudiantes inscritos: " + estudiantes.size());
        for (Estudiante e : estudiantes) {
            e.mostrarDatos();
        }
    }

    public static int getContadorCursos() {
        return contadorCursos;
    }
}
