package evalucion.domain;

import evalucion.exception.AccesoDatosEx;
import evalucion.exception.EscrituraEx;

public class Escrito extends Examen {

    private int duracion;
    private int nota;

    private static int contadorAprobado;

    public Escrito(){

    }

    public Escrito(int duracion, int nota, String fecha) throws AccesoDatosEx {
        super(fecha);
        if (duracion<0 && nota<0){throw new EscrituraEx("ingrese valores positivos");}
        this.duracion = duracion;
        this.nota = nota;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int verificar() {
        if( duracion>0 && duracion<90 && nota>=6 ){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Examen escrito: " +
                "duracion=" + duracion +
                ", nota=" + nota +" "+super.toString() ;
    }
}
