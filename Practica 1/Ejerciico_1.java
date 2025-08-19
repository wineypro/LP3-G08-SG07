package Ejercicios_Propuestos;

public class Ejerciico_1 {
	
	public static int sumarArreglo(int[]arreglo)
	{
		int suma=0;
		for (int num:arreglo)
		{
			suma = suma + num;
		}
		return suma;
	}
	

	public static void main(String[] args) 
	{
		int [] arr= {1,2,3,4};
		System.out.println(sumarArreglo(arr));
	}
	

}
