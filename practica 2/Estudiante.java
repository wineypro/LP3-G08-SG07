package Ejercicio;

import java.util.ArrayList;

public class Estudiante extends Persona {
    private String matricula;
    private ArrayList<Curso> cursosInscritos = new ArrayList<>();
    private static int contadorEstudiantes = 0;

    public Estudiante(String nombre, String correo, String matricula) {
        super(nombre, correo);
        this.matricula = matricula;
        contadorEstudiantes++;
    }

    public void inscribirseEnCurso(Curso curso) {
        if (curso.agregarEstudiante(this)) {
            cursosInscritos.add(curso);
        }
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Estudiante: " + nombre + " | Matrícula: " + matricula);
    }

    public static int getContadorEstudiantes() {
        return contadorEstudiantes;
    }
}
