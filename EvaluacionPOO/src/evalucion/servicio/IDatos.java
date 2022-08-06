package evalucion.servicio;

import evalucion.domain.Alumno;
import evalucion.exception.*;

import java.util.List;

public interface IDatos {

    int aprobados(String nombreArchivo) throws LecturaEx;

    boolean existe(String nombreArchivo) throws AccesoDatosEx;

    List<Alumno> listar(String nombre)throws LecturaEx;

    void escribir(Alumno alumno, String nombreArchivo, boolean anexar)throws EscrituraEx;
    void crear(String nombreArchivo)throws AccesoDatosEx;

    void borrrar(String nombreArchivo)throws AccesoDatosEx;
}
