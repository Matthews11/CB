package com.pruebas.arreglos;
 
import java.util.Scanner;

//Crea un array de números de un tamaño pasado por teclado, el array contendrá números aleatorios pares entre los números deseados, por último nos indica cual es el mayor de todos.
//
//Haz un método para comprobar que el número aleatorio es primo, puedes hacer todos lo métodos que necesites.

public class Ejercicio_3 {

	private static Scanner reader = new Scanner(System.in);

	private static int [] numeros;

	private static int tamanno; 

	public static void main(String[] args) {
		System.out.println("Indica el tamanno del arreglo");
		tamanno = reader.nextInt();
		numeros = new int[tamanno];

		numberRandomCousin();
		show();
		numeroMayor();
	}

	public static void numberRandomCousin() { 
		for (int i = 1; i < numeros.length; i++) {
			Integer numberRandom = (int) (Math.random()*10+1); 
			if (numberRandom % 2 == 0) {
				numeros[i] = numberRandom;
			}else {
				numberRandom=0;
				i--;
			} 
		}
		
	}
	
	public static void show() {
		 
		for(int i=0; i<numeros.length;i++) {
			System.out.println("Los numeros pares son: "+numeros[i]);
		}
		
	}
	
	public static void numeroMayor() {
		int mayor=0;
		for(int i=0; i<numeros.length;i++) {
			if(numeros[i]>mayor) {
				mayor=numeros[i];
			}
		}
		System.out.println("El numero mayor es: "+mayor);
	}
	 

}
