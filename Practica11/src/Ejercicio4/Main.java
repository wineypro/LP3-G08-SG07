package Ejercicio4;

import java.util.Scanner;

public class Main {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el monto del pedido:");
        double monto = sc.nextDouble();
        Pedido pedido = new Pedido(monto);

        while (true) {
            System.out.println("\n1) Confirmar pedido");
            System.out.println("2) Cancelar pedido");
            System.out.println("3) Aplicar descuento");
            System.out.println("4) Ver estado del pedido");
            System.out.println("5) Salir");
            int op = sc.nextInt();

            Comando c = null;

            if (op == 1) c = new ConfirmarPedido(pedido);
            if (op == 2) c = new CancelarPedido(pedido);
            if (op == 3) {
            	System.out.println("Seleccione estrategia de descuento:");
                System.out.println("1) Sin descuento");
                System.out.println("2) Descuento 10%");
                System.out.println("3) Descuento 20%");
                int opcion = sc.nextInt();

                EstrategiaDescuento estrategia;
                if (opcion == 2) estrategia = new Descuento10();
                else if (opcion == 3) estrategia = new Descuento20();
                else estrategia = new SinDescuento();
            	c = new AplicarDescuento(pedido, estrategia);
            }
            if (op == 4) System.out.println(pedido.resumen());
            if (op == 5) break;

            if (c != null) c.ejecutar();
        }
    }
}
