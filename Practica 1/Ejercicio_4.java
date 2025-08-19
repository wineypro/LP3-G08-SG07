package a;
import java.util.Scanner;

public class Ejercicio_4 {
	public static double Menor(double[] n1){
		double men = 999999999999.9;
		for(int i = 0; i<=2; i++) {
			if(n1[i]<men) {
				men = n1[i];
			}
		}
		return men;
	}
	
	public static void main(String[] args) {
		double [] n = new double[3];
		
		for(int i = 0; i<=2; i++) {
			Scanner Scan = new Scanner(System.in);
			System.out.println("ingresa decimal");
			 n[i] = Scan.nextDouble();
		}
		System.out.println(Menor(n));
	}

}
