package com.pruebas;

import java.util.Scanner;

public class Main {

	private static int opcion = 0;
	private static final Scanner leer = new Scanner(System.in);

	public static void main(String[] args) {
		Acciones acciones = new Acciones();

		do {
			System.out.println(
					"que seas hacer ?" + "\n1. ingresar " + "\n2. actualizar" + "\n3. eliminar" + "\n4. mostrar" +"\n0. salir");
			opcion = leer.nextInt();

			switch (opcion) {
			case 1:
				acciones.insertar();
				break;

			case 2:
				acciones.actualizar();
				break;
			case 3:
				acciones.eliminar();
				break;
				
			case 4:
				acciones.mostrar();
				break; 
				
				default:
					System.out.println("selecciona una opcion valida");
					break;
			}
		} while (opcion != 0);
	}

}
