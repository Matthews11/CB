package gm.peliculas.datos;

import gm.peliculas.domain.Pelicula;
import gm.peliculas.excepciones.AccesoDatosEx;
import gm.peliculas.excepciones.EscrituraDatosEx;
import gm.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface AccesoDatos {

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Pelicula> listar(String nombre)throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar)throws EscrituraDatosEx;

    String buscar(String nombreArchivo, String buscar)throws LecturaDatosEx;

    void crear(String nombreArchivo)throws AccesoDatosEx;

    void borrrar(String nombreArchivo)throws AccesoDatosEx;

}
