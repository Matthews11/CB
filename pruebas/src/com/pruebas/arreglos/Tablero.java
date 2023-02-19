package com.pruebas.arreglos;

public class Tablero {

	public static void main(String[] args) {
		Integer matriz[][] = new Integer[10][10];

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length; j++) {
				
				matriz[i][j] = 1 - (i + j) % 2;
			}
		}

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+" ");
				 
			}
			System.out.print("\n");
		}

	}

}
