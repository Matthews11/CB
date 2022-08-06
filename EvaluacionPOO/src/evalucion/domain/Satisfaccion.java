package evalucion.domain;

import java.io.Serializable;

public enum Satisfaccion implements Serializable {
     Insuficente("insuficente"),Suficiente("suficiente"),Excelente("excelente");

    private String satisfaccion;
    Satisfaccion(String satisfaccion){
        this.satisfaccion=satisfaccion;
    }



}
