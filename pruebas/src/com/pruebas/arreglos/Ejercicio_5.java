package com.pruebas.arreglos;

import java.util.Arrays;

//que numero se repite
public class Ejercicio_5 {

	private static final int[] numeros = { 2, 4, 6, 3, 8, 7, 9, 7, 7 };

	private static final int[] ordenar = new int[9];

	public static void main(String[] args) {
		showArrays();
//		System.out.println("forma ascendente");
//		ordenarArrays();
//		System.out.println("forma descendente");
//		ordenarArraysDescendente();
		
	}

	public static void ordenarArrays() {
		Arrays.sort(numeros);
		for(int i=0; i< numeros.length;i++) {
			System.out.println(numeros[i]);
		}
	}
	
	public static void ordenarArraysDescendente() {
		Arrays.sort(numeros);
		for(int i=numeros.length; i>0; i--) {
			System.out.println(numeros[i-1]);
		}
	}

	public static void showArrays() {
		for (int j = 0; j <=numeros.length; j++) {
			System.out.println("normal:"+numeros[j]+" mas 1: "+numeros[j+1]);
		}
	}
}
