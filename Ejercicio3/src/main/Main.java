package main;

import gm.peliculas.domain.Pelicula;
import gm.peliculas.negocio.CatalogoPeliculas;
import gm.peliculas.negocio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class Main {

    private static final Scanner leer = new Scanner(System.in);
    private static final CatalogoPeliculas cp = new CatalogoPeliculasImpl();
    private static int opcion=-1;
    private static final String NOMBRE_ARCHIVO="c:\\pruebajava\\pelicula.txt";

    public static void main(String[] args) {

    while (opcion!=0) {
        try {
            System.out.println("1. inciar catalogo \n" +
                    "2. agregar pelicula \n" +
                    "3. listar pelicula \n" +
                    "4. buscar pelicula \n" +
                    "0. salir");
            opcion = Integer.parseInt(leer.nextLine());

            switch (opcion) {
                case 1:
                    cp.iniciarArchivo(NOMBRE_ARCHIVO);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la pelicula");
                    String nombre = leer.nextLine();
                    cp.agregarPelicula(nombre, NOMBRE_ARCHIVO);
                    break;
                case 3:
                    cp.listarPelicula(NOMBRE_ARCHIVO);
                    break;
                case 4:
                    String buscar;
                    System.out.println("Ingrese la pelicula a buscar");
                    buscar = leer.nextLine();
                    cp.buscarPelicula(NOMBRE_ARCHIVO, buscar);
                    break;

                case 0:

                    System.out.println("Salu pa");
                    break;

                default:
                    System.out.println("Seleccione una opcion");
                    break;
            }
            System.out.println("\n");
        }catch (Exception e){
            System.out.println("Ocurrio un error");
        }
    }
    }
}
