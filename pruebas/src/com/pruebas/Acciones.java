package com.pruebas;


import java.util.Scanner;

public class Acciones {

	private final Scanner leer = new Scanner(System.in); 
	private Modelo[] persona;

	public void insertar() {
		 
		System.out.println("ingrese la cantidad de usuario");
		int numero = leer.nextInt();
		persona = new Modelo[numero];
		leer.nextLine();
		
		for(int i=0; i<persona.length;i++) {
			System.out.println("Ingrese el nombre");
			String name = leer.nextLine();

			System.out.println("Ingrese el precio");
			int price = leer.nextInt();

			leer.nextLine();

			persona[i] = new Modelo(name, price);
		}
		
		
		
	}


	public void mostrar() {
		System.out.println(persona.length);
		for (int i = 0; i < persona.length; i++) {
			System.out.println(persona[i].toString());
		}
	}

	public void actualizar() {

		System.out.println("Ingrese el nombre para buscarlo");
		String name = leer.nextLine();

		System.out.println("Ingrese el precio para buscarlo");
		int price = leer.nextInt();
		leer.nextLine();

		System.out.println("Ingrese el nombre para actualizarlo");
		String nuevoName = leer.nextLine();

		System.out.println("Ingrese el precio para actualizarlo");
		int nuevoPrice = leer.nextInt();
		leer.nextLine();

		for (int i = 0; i < persona.length; i++) {
			if (persona[i].getName().equals(name) && persona[i].getPrice().equals(price)) {
				persona[i].setName(nuevoName);
				persona[i].setPrice(nuevoPrice);
				System.out.println("se actualizo correctamente");
			}
		}

	}

	public void eliminar() {
		System.out.println("Ingrese el nombre para eliminarlo");
		String name = leer.nextLine();

		System.out.println("Ingrese el precio para eliminarlo");
		int price = leer.nextInt();
		leer.nextLine();

		for (int i = 0; i < persona.length; i++) {
			if (persona[i].getName().equals(name) && persona[i].getPrice().equals(price)) {
				persona[i].setName(null);
				persona[i].setPrice(null);
				System.out.println("se elimino correctamente");
			}
		}
	}
	
}
