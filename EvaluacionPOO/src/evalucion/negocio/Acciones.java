package evalucion.negocio;

import evalucion.domain.Alumno;
import evalucion.exception.AccesoDatosEx;
import evalucion.exception.LecturaEx;

public interface Acciones {

    void agregarAlumno(Alumno alumno, String nombreArchivo) throws AccesoDatosEx;

    void listarAlumnos(String nombreArchivo);

    int aprobados(String nombreArchivo) throws LecturaEx;

    void iniciarArchivo(String nombreArchivo);
}
