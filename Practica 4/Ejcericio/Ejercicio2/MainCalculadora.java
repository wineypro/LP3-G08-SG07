package Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCalculadora {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("CALCULADORA BÁSICA");
        System.out.println("Operaciones disponibles: +, -, *, /");
        
        try {
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Ingrese el operador (+, -, *, /): ");
            char operador = scanner.next().charAt(0);
            
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();
            
            double resultado = 0;
            
            switch (operador) {
                case '+':
                    resultado = calc.sumar(num1, num2);
                    break;
                case '-':
                    resultado = calc.restar(num1, num2);
                    break;
                case '*':
                    resultado = calc.multiplicar(num1, num2);
                    break;
                case '/':
                    resultado = calc.dividir(num1, num2);
                    break;
                default:
                    throw new IllegalArgumentException("Operador no válido: " + operador);
            }
            
            System.out.println("Resultado: " + resultado);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar números válidos");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DivisionPorCeroException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Operación finalizada");
        }
    }
}
