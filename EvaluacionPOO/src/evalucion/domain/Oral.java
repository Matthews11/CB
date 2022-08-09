package evalucion.domain;

public class Oral extends Examen{

    private Satisfaccion satisfaccion;

    public Oral(){}

    public Oral(Satisfaccion satisfaccion, String fecha){
        super(fecha);
        this.satisfaccion=satisfaccion;
    }
    @Override
    public int verificar() {
        if (satisfaccion.name()=="Suficiente"|| satisfaccion.name()=="Excelente") {
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
