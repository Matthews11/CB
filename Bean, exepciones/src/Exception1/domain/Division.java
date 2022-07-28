package Exception1.domain;

import javax.management.OperationsException;

public class Division {

    private int numerador;

    private int denominador;

    public Division (int numerador, int denominador)throws OperationException {
        if (denominador==0){

            throw new OperationException("Denominador igual a 0");
        }
        this.numerador=numerador;
        this.denominador=denominador;
    }


    public void mostrarOperacion(){
        System.out.println("El resultado es: "+numerador/denominador);
    }
}
