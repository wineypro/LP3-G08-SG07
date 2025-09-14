package Ejercicio4;

class Estudiante {
    private String nombre;
    private int edad;
    private String codigo;

    public Estudiante(String nombre, int edad, String codigo) {
        this.nombre = nombre;
        this.edad = edad;
        this.codigo = codigo;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCodigo() { return codigo; }

    @Override
    public String toString() {
        return "Estudiante{" +
               "nombre='" + nombre + '\'' +
               ", edad=" + edad +
               ", codigo='" + codigo + '\'' +
               '}';
    }
}