package main;

import evalucion.domain.*;
import evalucion.exception.*;
import evalucion.servicio.*;

import java.util.Scanner;

public class Main {
    private static IDatos datos = new DatosImpl();
    private static int opcion=-1;
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) throws AccesoDatosEx {
        while (opcion!=0) {
            System.out.println("1. agregar alumno\n" +
                    "2. listar los aprobados\n" +
                    "3. listar todos los alumnos\n" +
                    "0. salir \n");
                opcion= Integer.parseInt(leer.nextLine());
            switch (opcion) {
                case 1:

                    System.out.println("\nIngrese la fecha del examen oral");
                    String f=leer.nextLine().trim();

                    System.out.println("\nIngrese la satisfaccion del examen oral (insuficiente, suficiente o excelente)");
                    String s=leer.nextLine().trim();

                    System.out.println("\nIngrese la cantidad de tiempo que se tardo realizando el examen escrito");
                    int t= Integer.parseInt(leer.nextLine());

                    System.out.println("\nIngrese la nota del examen escrito");
                     int n=Integer.parseInt(leer.nextLine());

                    System.out.println("\nIngrese la fecha del examen escrito");
                    String f2=leer.nextLine().trim();

                    System.out.println("\nIngrese el DUI del alumno");
                    String d=leer.nextLine().trim();

                    System.out.println("\nIngrese el nombre ");
                    String no=leer.nextLine().trim();

                    System.out.println("\nIngrese el apellido ");
                    String a=leer.nextLine().trim();

                    Oral oral = new Oral(s, f);
                    Escrito escrito = new Escrito(t, n,f2);
                    Alumno alumno = new Alumno(d, no, a, escrito, oral);

                    datos.agregarAlumnos(alumno);
                break;
                case 2: datos.aprobados();
                break;
                case 3: datos.listar();
                break;
                case 0:
                    System.out.println("Salu pa");
                    break;
                default:
                    System.out.println("elija una opcion valida");
                    break;
                }
           }
        }
    }

