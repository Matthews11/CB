package evalucion.domain;

public class Oral extends Examen{

    private String satisfaccion;

    public Oral(String satisfaccion, String fecha){
        super(fecha);
        this.satisfaccion=satisfaccion;
    }
    @Override
    public int verificar() {
        if (satisfaccion.equals("suficiente")|| satisfaccion.equals("excelente")) {
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return " Examen oral: " +
                "satisfaccion=" + satisfaccion +" "+super.toString() ;
    }
}
