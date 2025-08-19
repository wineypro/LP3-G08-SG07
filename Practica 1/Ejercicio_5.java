package Ejercicios_Propuestos;

public class Ejercicio_5 {

	public static void main(String[] args) 
	{
		int horas = 1; 
        double cargo = calcularCargo(horas);
        System.out.println("Horas: " + horas + " -> Cargo: S/" + cargo);

	}
	public static double calcularCargo(int horas)
	{
        if (horas <= 0) return 0.0;

        double total = 3.0; // Primera hora
        if (horas > 1) {
            total += (horas - 1) * 0.5;
        }

        if (total > 12.0) {
            total = 12.0; // Cargo máximo
        }

        return total;
	}
}
