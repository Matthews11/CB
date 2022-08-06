package evalucion.negocio;

import evalucion.domain.Alumno;
import evalucion.exception.AccesoDatosEx;
import evalucion.exception.LecturaEx;
import evalucion.servicio.DatosImpl;
import evalucion.servicio.IDatos;

import java.util.List;

public class GraduacionImpl implements Graduacion{

    private final IDatos datos;

    public GraduacionImpl(){
        this.datos=new DatosImpl();
    }

    @Override
    public void agregarAlumno(Alumno alumno, String nombreArchivo) throws AccesoDatosEx {
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);
            datos.escribir(alumno,nombreArchivo,anexar);
        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarAlumnos(String nombreArchivo) {
        try{
            List<Alumno> alumnos = datos.listar(nombreArchivo);
            for (Alumno alumno:alumnos) {
                System.out.println("Alumnos "+alumno);
            }
        }catch(AccesoDatosEx ex){
            System.out.println("Error de acceso datos");
            ex.printStackTrace();
        }
    }

    @Override
    public int aprobados(String nombreArchivo) throws LecturaEx {
        int total = 0;
        total = datos.aprobados(nombreArchivo);
        return total;
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
