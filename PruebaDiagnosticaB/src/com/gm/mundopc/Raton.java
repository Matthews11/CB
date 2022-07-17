package com.gm.mundopc;

public class Raton extends DispositivosEntrada{
    //atributos
    private final int idRaton;

    private static int contadorRaton;

    //constructor
    public Raton(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        idRaton=++contadorRaton;
    }

    //tostring
    @Override
    public String toString() {
        return "Raton {"+"id= "+idRaton+super.toString();
    }

}
