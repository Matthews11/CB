package com.gm.mundopc;

public class Teclado extends DispositivosEntrada{

    //atributos
    private final int idTeclado;

    private static int contadorTeclado;

    //constructor
    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        idTeclado=++contadorTeclado;
    }

    //tostring

    @Override
    public String toString() {
        return "Teclado {"+"id= "+idTeclado+", "+ super.toString();
    }
}
