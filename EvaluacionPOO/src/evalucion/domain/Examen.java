package evalucion.domain;

public abstract class Examen {
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
