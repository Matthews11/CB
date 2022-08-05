package gm.peliculas.datos;

import gm.peliculas.domain.Pelicula;
import gm.peliculas.excepciones.AccesoDatosEx;
import gm.peliculas.excepciones.EscrituraDatosEx;
import gm.peliculas.excepciones.LecturaDatosEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements AccesoDatos{


    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo= new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        File archivo = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea=null;
            linea=entrada.readLine();
            while (linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        }catch (IOException ex){
            ex.printStackTrace();

        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito correctamente el archivo");
        }catch (IOException ex){
            ex.printStackTrace();

        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreArchivo);
        String resultado = null;

        try{
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea=null;
            int i = 0;
            linea=entrada.readLine();

            while(linea!=null){
                if (buscar !=null && buscar.equalsIgnoreCase(linea)){
                    resultado="Pelicula "+ linea.trim()+" encontrada en indice"+i;
                    break;
                }
                linea=entrada.readLine();
                i++;
            }
            entrada.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se creo correctamente el archivo");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void borrrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
         archivo.delete();
        System.out.println("Se ha borrado el archivo correctamente");

    }
}
