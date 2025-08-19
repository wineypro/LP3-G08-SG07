package a;

import java.util.Scanner;

public class Ejercicio_2 {

	public static void main(String[] args) {
		
		int [] arreglo = new int[10];
		int n1 = -99999;
		int n = n1;
		for(int i=0; i<=9;i++) {
			while(n<=n1) {
				Scanner Scan = new Scanner(System.in);
				System.out.println("ingresa numero: ");
				n = Scan.nextInt();
				if(n<=n1) {
					System.out.println("error, ingrese un numero mayor");
				}
			}
			n1=n;
			arreglo[i] = n;
		}
		for(int a = 0; a<=9;a++) {
			System.out.println(arreglo[a]);
		}
	}

}
