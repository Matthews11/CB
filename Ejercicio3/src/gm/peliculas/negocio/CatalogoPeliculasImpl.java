package gm.peliculas.negocio;

import gm.peliculas.datos.AccesoDatos;
import gm.peliculas.datos.AccesoDatosImpl;
import gm.peliculas.domain.Pelicula;
import gm.peliculas.excepciones.AccesoDatosEx;
import gm.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {
    private  final AccesoDatos DATOS ;

    public CatalogoPeliculasImpl(){
        this.DATOS = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexo = false;

        try {
            anexo = DATOS.existe(nombreArchivo);
            DATOS.escribir(pelicula,nombreArchivo,anexo);
        } catch (AccesoDatosEx e) {
            e.printStackTrace();
        }

    }

    @Override
    public void listarPelicula(String nombreArchivo) {
        try {
            List<Pelicula> peliculas = DATOS.listar(nombreArchivo);
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        String resultado = null;
        try {
            resultado = DATOS.buscar(nombreArchivo,buscar);
        }catch (LecturaDatosEx ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if (DATOS.existe(nombreArchivo)){
                DATOS.borrrar(nombreArchivo);
                DATOS.crear(nombreArchivo);
            }else {
                DATOS.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx e) {
            e.printStackTrace();
        }

    }
}
