package Ejercicio2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CalculadoraDePrecios calc = new CalculadoraDePrecios();

        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Precio del producto: ");
        double precio = sc.nextDouble();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        Producto producto = new Producto(nombre, precio, cantidad);

        int opcion;

        do {
            System.out.println("\n=== ESTRATEGIAS DE DESCUENTO ===");
            System.out.println("1. Sin descuento");
            System.out.println("2. Descuento fijo (10%)");
            System.out.println("3. Descuento porcentual (2 iguales → 30%)");
            System.out.println("4. Descuento porcentual acumulado (3+ → 50% sobre el más barato)");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    calc.setEstrategia(new SinDescuento());
                    break;

                case 2:
                    calc.setEstrategia(new DescuentoFijo());
                    break;

                case 3:
                    calc.setEstrategia(new DescuentoPorcentual());
                    break;

                case 4:
                    calc.setEstrategia(new DescuentoPorcentualAcumulado());
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    continue;

                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            double precioFinal = calc.calcularPrecioFinal(producto);
            System.out.println("Precio final: S/ " + precioFinal);

        } while (opcion != 5);

        sc.close();
    }
}
