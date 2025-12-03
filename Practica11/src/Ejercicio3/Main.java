package Ejercicio3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Luz luz = new Luz();
        Puerta puerta = new Puerta();
        InvocadorControl control = new InvocadorControl();

        int opcion;

        do {
            System.out.println("\n=== SISTEMA DOMÓTICO (Patrón Command) ===");
            System.out.println("1. Encender luz");
            System.out.println("2. Apagar luz");
            System.out.println("3. Abrir puerta");
            System.out.println("4. Cerrar puerta");
            System.out.println("5. Deshacer última acción");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    control.ejecutarComando(new EncenderLuzCommand(luz));
                    break;

                case 2:
                    control.ejecutarComando(new ApagarLuzCommand(luz));
                    break;

                case 3:
                    control.ejecutarComando(new AbrirPuertaCommand(puerta));
                    break;

                case 4:
                    control.ejecutarComando(new CerrarPuertaCommand(puerta));
                    break;

                case 5:
                    control.deshacerUltimo();
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
