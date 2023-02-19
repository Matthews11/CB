package com.pruebas.arreglos;

public class Ejercicio_7 {
	
	
	public static void main(String[] args) {
		String palabra="ese";
//		 String a=palabra.trim();
		for(int i=0; i< palabra.length(); i++) {
			if(palabra.charAt(i) == palabra.charAt(palabra.length()-i-1)) {
				System.out.println("es palindromo");
			} else {
				System.out.println("no es palindromo");
			}
		}
	}

}
