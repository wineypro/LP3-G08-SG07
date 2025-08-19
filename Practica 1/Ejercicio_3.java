package Ejercicios_Propuestos;
import java.util.Random;
public class Ejercicio_3 
{
	
	public static void main(String[] args) 
	{
	int [] caras= new int [6];
	Random r =new Random();
	
	for (int i = 0; i < 20000; i++) 
	{
        int resultado = r.nextInt(6); // 0 a 5
        caras[resultado]++;
    }

    for (int i = 0; i < 6; i++) 
    {
        System.out.println("Cara " + (i + 1) + ": " + caras[i]);
    }
	}
}	
