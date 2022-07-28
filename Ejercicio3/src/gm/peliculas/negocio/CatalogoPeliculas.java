package gm.peliculas.negocio;

public interface CatalogoPeliculas {

    void agregarPelicula(String nombrePelicula,String nombreArchivo);

    void listarPelicula(String nombreArchivo);

    void buscarPelicula(String nombreArchivo, String buscar);

    void iniciarArchivo(String nombreArchivo);


}
