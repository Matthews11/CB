package com.pruebas.arreglos;

import java.util.Scanner;

//Crea un array de 10 posiciones de números con valores pedidos por teclado. Muestra por consola el indice y el valor al que corresponde.
//Haz dos métodos, uno para rellenar valores y otro para mostrar.

public class Ejercicio_1 {

	private static Scanner leer = new Scanner(System.in);

	private static Integer[] numeros = new Integer[10];

	public static void main(String[] args) {

		System.out.println("Ingrese los valores");

		numeros = llenar();
		show(numeros);

	}

	public static Integer[] llenar() {
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = leer.nextInt();
		}
		return numeros;
	}

	public static void show(Integer[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println("El indice es: " + i + " el valor es: " + array[i]);
		}
	}
}
