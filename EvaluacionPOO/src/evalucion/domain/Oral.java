package evalucion.domain;

import java.io.Serializable;

public class Oral extends Examen implements Serializable {

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
        return
                "Examen oral: \n" +
                        ", satisfaccion:" + satisfaccion +", "+super.toString() ;
    }
}
