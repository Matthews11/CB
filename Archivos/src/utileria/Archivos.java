package utileria;

import java.io.*;

public class Archivos {

    public static void crearArchivo(String nombreArchivo){
        File archivo= new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            System.out.println("El archivo se creo correctamente\n");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void escribirArchivo(String nombreArchivo){
        File archivo= new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            String contenido="Contenido a escribir en el archivo";
            salida.println(contenido);
            salida.println();
            salida.println("fin de escritura");
            salida.close();
            System.out.println("Se ha escrito correctamente el archivo\n");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void leerArchivo(String nombreArchivo){
        File archivo= new File(nombreArchivo);
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura;
            lectura = entrada.readLine();
            while (lectura !=null){
                System.out.println("Lectura: "+lectura);
                lectura=entrada.readLine();
            }
            entrada.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void anexarArchivo(String nombreArchivo){
        File archivo= new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));
            String contenido="Anexando informacion en el archivo";
            salida.println(contenido);
            salida.println();
            salida.println("fin de Anexar");
            salida.close();
            System.out.println("Se ha Anexado la infomacion correctamente el archivo\n");
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }


}
