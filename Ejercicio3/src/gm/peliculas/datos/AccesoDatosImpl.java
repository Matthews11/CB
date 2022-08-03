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
            System.out.println("Se ha escrito correctamente "+pelicula);
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
            String linea = null;
            linea = entrada.readLine();
            int indice=1;
            while(linea !=null){
                if(buscar!=null && buscar.equals(linea) ){
                    resultado="Pelicula "+linea+" encontrada en el indice"+indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.println("Se ha creado correctamente");
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void borrrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        if(archivo.exists()){
            archivo.delete();
        }else {
            throw new AccesoDatosEx("No se borro la pelicula porque no existe ");
        }


    }
}
