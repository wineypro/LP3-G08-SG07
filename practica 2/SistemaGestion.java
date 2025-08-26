package Ejercicio;

public class SistemaGestion {
    public static void main(String[] args) {
        Profesor prof1 = new Profesor("Dra. Juárez", "juarez@uni.edu", "Programación");
        Categoria catProg = new Categoria("Programación");

        Curso cursoJava = new Curso("Java Básico", prof1, catProg);

        Estudiante est1 = new Estudiante("Luis Pérez", "luis@correo.com", "2021001");
        Estudiante est2 = new Estudiante("Ana Torres", "ana@correo.com", "2021002");

        est1.inscribirseEnCurso(cursoJava);
        est2.inscribirseEnCurso(cursoJava);

        cursoJava.mostrarCurso();

        System.out.println("\nTotal estudiantes: " + Estudiante.getContadorEstudiantes());
        System.out.println("Total cursos: " + Curso.getContadorCursos());
    }
}
