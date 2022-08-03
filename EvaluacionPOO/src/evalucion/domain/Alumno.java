package evalucion.domain;

import evalucion.exception.AccesoDatosEx;

public class Alumno {
    private String dui;
    private String nombre;
    private String apellido;
    private final Escrito examenEscrito;
    private Oral oral;

    private static  int contadorAprobados=0;


    public Alumno(String dui, String nombre, String apellido, Escrito examenEscrito , Oral oral) throws AccesoDatosEx {
        this.dui = dui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.examenEscrito =  examenEscrito;
        this.oral=oral;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Escrito getExamenEscrito() {
        return examenEscrito;
    }

    public Oral getOral() {
        return oral;
    }

    public void setOral(Oral oral) {
        this.oral = oral;
    }

    @Override
    public String toString() {
        return "Alumno: " +
                "dui=" + dui +
                " nombre=" + nombre  +
                ", apellido=" + apellido  +
                ", \n" + examenEscrito +
                ", \n" + oral +
                '\n';
    }
}
