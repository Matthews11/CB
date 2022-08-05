package gm.peliculas.negocio;

import gm.peliculas.datos.AccesoDatos;
import gm.peliculas.datos.AccesoDatosImpl;
import gm.peliculas.domain.Pelicula;
import gm.peliculas.excepciones.AccesoDatosEx;
import gm.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula,nombreArchivo,anexar);
        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPelicula(String nombreArchivo) {
        try{
            List<Pelicula> peliculas = datos.listar(nombreArchivo);
            for (Pelicula pelicula:peliculas) {
                System.out.println("Pelicula "+pelicula);
            }
        }catch(AccesoDatosEx ex){
            System.out.println("Error de acceso datos");
            ex.printStackTrace();
        }

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        String resultado = null;
        try{
            resultado= datos.buscar(nombreArchivo,buscar);
        }catch (LecturaDatosEx ex){
            System.out.println("Erro al buscar la pelicula");
            ex.printStackTrace();
        }
        System.out.println("Resultado busqueda "+resultado);

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {

        try {
            if(datos.existe(nombreArchivo)){
                datos.borrrar(nombreArchivo);
                datos.crear(nombreArchivo);
            }else {
                datos.crear(nombreArchivo);
            }

        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
}
