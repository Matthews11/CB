package evalucion.domain;

import java.io.Serializable;

public abstract class Examen implements Serializable {
    protected String fecha;

    protected Examen() {
    }
    protected Examen(String fecha) {
        this.fecha = fecha;
    }

    public abstract int verificar();

    @Override
    public String toString() {
        return "fecha: " + fecha ;
    }
}
