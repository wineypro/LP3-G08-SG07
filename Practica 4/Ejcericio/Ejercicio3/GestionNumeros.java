package Ejercicio3;

import java.util.Scanner;

public class GestionNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("GESTIÓN DE NÚMEROS NO NEGATIVOS");
        System.out.println("=================================");
        
        try {
            Numero numero = new Numero();
            
            System.out.print("Ingrese un valor numérico (no negativo): ");
            double valorIngresado = scanner.nextDouble();
            
            numero.setValor(valorIngresado);
            
            System.out.println("Valor establecido correctamente: " + numero.getValor());
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Debe ingresar un valor numérico válido");
            scanner.next();
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("=================================");
            System.out.println("Programa finalizado");
        }
    }
}