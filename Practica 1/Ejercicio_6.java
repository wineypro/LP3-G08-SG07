package a;
import java.util.Scanner;

public class Ejercicio_6 {
	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		System.out.println("ingresa horas");
		int hora = Scan.nextInt();
		System.out.println("ingresa minutos");
		int minuto = Scan.nextInt();
		System.out.println("ingresa segundos");
		int segundo = Scan.nextInt();
		int total = 0;
		total = hora*60*60+minuto*60+segundo;
		System.out.println(total+" segundos");
	}
}
