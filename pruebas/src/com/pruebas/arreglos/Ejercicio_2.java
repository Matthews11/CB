package com.pruebas.arreglos;

import java.util.Scanner;

//Crea un array de números donde le indicamos por teclado el tamaño del array, rellenaremos el array con números aleatorios entre 0 y 9, 
//al final muestra por pantalla el valor de cada posición y la suma de todos los valores. Haz un método para rellenar el array (que tenga como parámetros los números 
//entre los que tenga que generar), para mostrar el contenido y la suma del array y un método privado para generar número aleatorio (lo puedes usar para otros ejercicios).

public class Ejercicio_2 {

	private static Scanner reader = new Scanner(System.in);

	private static Integer[] numeros;

	private static Integer total = 0;

	public static void main(String[] args) {

		Integer tamanno;

		System.out.println("indica el tamanno del arreglo");
		tamanno = reader.nextInt();

		numeros = new Integer[tamanno];
		random();
		show();

	}

	public static void random() {
		for (int i = 0; i < numeros.length; i++) {
			Integer aleatorio = (int) (Math.random() * 10);
			System.out.println(aleatorio);
			numeros[i] = aleatorio;
		}
	}

	public static void show() {

		for (int i = 0; i < numeros.length; i++) {
			total += numeros[i];
			System.out.println("El valor de la posicion: " + i + " es: " + numeros[i]);

		}
		System.out.println("El total es: " + total);
	}
}
