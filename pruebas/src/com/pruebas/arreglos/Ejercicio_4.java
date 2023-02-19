package com.pruebas.arreglos;
//ejercicio 4
public class Ejercicio_4 {

	private static final int [] numeros = {2,4,1,6,5};
	
	//main
	public static void main(String[] args) {
		show();
		numeroMayor();
		numeroMenor();
	}
	
	//numero mayor
	public static void numeroMayor() {
		int mayor =0;
		for(int i=0; i<numeros.length;i++) {
			if(numeros[i]>mayor) {
				mayor = numeros[i];
			}
		}
		System.out.println("El numero mayor es: "+mayor);
	}
	
	//numero menor
	public static void numeroMenor() {
		int menor =100;
		for(int i=0; i<numeros.length;i++) {
			if(menor>numeros[i]) {
				menor = numeros[i];
			}
		}
		System.out.println("El numero menor es: "+menor);
	}
	
	//lista los numeros 
	public static void show() {
		for(int i=0; i<numeros.length;i++) {
			 System.out.println(numeros[i]);
		}
	}
}
