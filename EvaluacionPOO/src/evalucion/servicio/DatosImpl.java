package evalucion.servicio;

import evalucion.domain.Alumno;
import evalucion.exception.AccesoDatosEx;
import evalucion.exception.EscrituraEx;
import evalucion.exception.LecturaEx;

import java.util.ArrayList;
import java.util.List;

public class DatosImpl implements IDatos{

    private List<Alumno> alumnos;
    private static int total;

    public DatosImpl(){
        this.alumnos= new ArrayList<>();
    }

    @Override
    public void agregarAlumnos(Alumno alumno) throws EscrituraEx {
        if (alumno == null){
            throw new EscrituraEx("el objeto esta vacio\n ");
        }
        alumnos.add(alumno);
        System.out.println("Se agrego correctamente\n");
    }

    @Override
    public int aprobados()throws  LecturaEx {
        total=0;
        if (alumnos.isEmpty()){
            System.out.println("Error");
            throw new LecturaEx("La lista esta vacia");

        } else {
            for (int i = 0; i < alumnos.size(); i++) {
                if (alumnos.get(i).getOral().verificar()>=1 &&alumnos.get(i).getExamenEscrito().verificar()>0){
                total ++;
                System.out.println(alumnos.get(i));
            }
        }
            System.out.println("El total de aprobados es: " + total);
        } return total;
    }
    @Override
    public void listar() throws LecturaEx {

        if (alumnos.isEmpty()){
            System.out.println("Error");
            throw new LecturaEx("La lista esta vacia");
        }
        for (Alumno alumno:alumnos) {
            System.out.println(alumno);
        }
    }
}
