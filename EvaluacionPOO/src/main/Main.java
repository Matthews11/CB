package main;

import evalucion.domain.*;
import evalucion.exception.*;
import evalucion.negocio.Graduacion;
import evalucion.negocio.GraduacionImpl;
import evalucion.servicio.*;

import java.util.Scanner;

public class Main {
    private static Graduacion datos = new GraduacionImpl();
    private static int opcion=-1;
    private static Scanner leer = new Scanner(System.in);

    private static final String NOMBRE_ARCHIVO="/home/kraus/alumnos.txt";

    private static  Satisfaccion [] nivel = Satisfaccion.values();

    public static void main(String[] args) throws AccesoDatosEx {
        try{
        while (opcion!=0) {
            System.out.println("1. iniciar comprobacion \n" +
                    "2. agregar alumno\n" +
                    "3. listar los aprobados\n" +
                    "4. listar todos los alumnos\n"  +
                    "0. salir \n");
                opcion= Integer.parseInt(leer.nextLine());
            switch (opcion) {

                case 1:
                    datos.iniciarArchivo(NOMBRE_ARCHIVO);
                break;

                case 2:

                    System.out.println("\nIngrese la fecha del examen oral");
                    String f=leer.nextLine().trim();

                    System.out.println("\nIngrese la satisfaccion del examen oral (1. insuficiente, 2. suficiente 3. excelente)");
                    String s=leer.nextLine().trim();
                    Satisfaccion satisfaccion = nivel[Integer.parseInt(s)-1];
                    System.out.println(satisfaccion.ordinal());

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

                    Oral oral = new Oral(satisfaccion, f);
                    Escrito escrito = new Escrito(t, n,f2);
                    Alumno alumno = new Alumno(d, no, a, escrito, oral);

                    datos.agregarAlumno(alumno,NOMBRE_ARCHIVO);
                break;
                case 3:

                    datos.aprobados(NOMBRE_ARCHIVO);
                break;
                case 4: datos.listarAlumnos(NOMBRE_ARCHIVO);
                break;
                case 0:
                    System.out.println("Salu pa");
                    break;
                default:
                    System.out.println("elija una opcion valida");
                    break;
                }
           }
        }catch (AccesoDatosEx ex){
            System.out.println("ocurrio un error");
            ex.printStackTrace();
        }
    }
}

