package com.pruebas.arreglos;

import java.util.Arrays;

public class Ejercicio_6 {

	public static void main(String[] args) {

		int[] numero = { 4, 3, 7, 1, 5, 5, 7, 7 };
		Arrays.sort(numero);
		for (int i = 0; i < numero.length; i++) {
			System.out.println(numero[i]);
		}

		numMayor(numero);
//		repite(numero);

	}

	public static void repite(int[] num) {
		int numReapet = 0;
		int contador = 0;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] == num[i + 1]) {
				numReapet = num[i];
				contador++;
			} 
		}
		System.out.println(numReapet + " veces " + contador);

	}
	
	
	public static void numMayor(int [] num) {
		int mayor=0;
		
		for(int i=0; i< num.length-1; i++) {
			if(num[i] >= num[i+1]) {
				mayor = num[i];
			}
		}
		System.out.println("El numero mayor es:  "+mayor);
	}

}
