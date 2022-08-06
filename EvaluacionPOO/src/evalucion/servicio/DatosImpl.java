package evalucion.servicio;

import evalucion.domain.*;
import evalucion.exception.AccesoDatosEx;
import evalucion.exception.EscrituraEx;
import evalucion.exception.LecturaEx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatosImpl implements IDatos{

    private static int total;


    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo= new File(nombreArchivo);
        return archivo.exists();
    }
    @Override
    public void escribir(Alumno alumno, String nombreArchivo, boolean anexar) throws EscrituraEx {

        try{
            OutputStream file = new FileOutputStream(nombreArchivo);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);

            output.writeObject(new Alumno(alumno.getDui(),alumno.getNombre(),alumno.getApellido(),
            alumno.getExamenEscrito(),alumno.getOral()));
            output.close();
            buffer.close();
            System.out.println("Se guardo correctamente");
        }catch (IOException ex){
            ex.printStackTrace();
        } catch (AccesoDatosEx e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int aprobados(String nombreArchivo)throws  LecturaEx {
        List<Alumno> alumnos = listar(nombreArchivo);
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
    public List<Alumno> listar(String nombre) throws LecturaEx {
        List<Alumno> alumnos = new ArrayList<>();
        try {
            FileInputStream ficheroEntrada = new FileInputStream(nombre);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
            Alumno alumno = (Alumno) objetoEntrada.readObject();
            alumnos.add(alumno);
            objetoEntrada.close();
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return alumnos;
    }


        @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se creo correctamente el archivo");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void borrrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo correctamente");
    }

}
