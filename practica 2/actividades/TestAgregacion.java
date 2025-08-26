package Actividades;

public class TestAgregacion {
    public static void main(String[] args) {
        // Crear motores
        Motor motor1 = new Motor("Gasolina", 120);
        Motor motor2 = new Motor("Eléctrico", 200);

        // Crear automóviles
        Automovil auto1 = new Automovil("Toyota", "Corolla");
        Automovil auto2 = new Automovil("Tesla", "Model 3");

        // Asignar motores a los automóviles
        auto1.setMotor(motor1);
        auto2.setMotor(motor2);

        // Mostrar información
        System.out.println(auto1);
        System.out.println(auto2);
    }
}
