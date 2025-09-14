package Ejercicio4;

import java.util.NoSuchElementException;

class RegistroEstudiantes {
    private Estudiante[] estudiantes;
    private int cantidad;
    private static final int CAPACIDAD_INICIAL = 10;

    public RegistroEstudiantes() {
        estudiantes = new Estudiante[CAPACIDAD_INICIAL];
        cantidad = 0;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El nombre del estudiante no puede ser nulo o vacío");
        }
        
        if (cantidad == estudiantes.length) {
            ampliarCapacidad();
        }
        
        estudiantes[cantidad] = estudiante;
        cantidad++;
        System.out.println("✓ Estudiante agregado: " + estudiante.getNombre());
    }

    public Estudiante buscarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: El nombre de búsqueda no puede ser nulo o vacío");
        }
        
        for (int i = 0; i < cantidad; i++) {
            if (estudiantes[i].getNombre().equalsIgnoreCase(nombre.trim())) {
                return estudiantes[i];
            }
        }
        
        throw new NoSuchElementException("Error: No se encontró ningún estudiante con el nombre '" + nombre + "'");
    }

    public void mostrarEstudiantes() {
        if (cantidad == 0) {
            System.out.println("No hay estudiantes registrados");
            return;
        }
        
        System.out.println("\n--- LISTA DE ESTUDIANTES REGISTRADOS ---");
        for (int i = 0; i < cantidad; i++) {
            System.out.println((i + 1) + ". " + estudiantes[i]);
        }
    }

    private void ampliarCapacidad() {
        Estudiante[] nuevoArreglo = new Estudiante[estudiantes.length * 2];
        System.arraycopy(estudiantes, 0, nuevoArreglo, 0, cantidad);
        estudiantes = nuevoArreglo;
    }

    public int getCantidad() {
        return cantidad;
    }
}
