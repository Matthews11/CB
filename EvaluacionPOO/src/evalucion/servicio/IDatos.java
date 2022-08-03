package evalucion.servicio;

import evalucion.domain.Alumno;
import evalucion.exception.EscrituraEx;
import evalucion.exception.LecturaEx;

import java.util.List;

public interface IDatos {
    void agregarAlumnos(Alumno alumno) throws EscrituraEx;
    int aprobados() throws LecturaEx;

    void listar()throws LecturaEx;
}
