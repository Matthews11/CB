package com.gm.mundopc;

public class Orden {

    private final int idOrden;

    private final Computadora computadoras[];

    private static int contadorOrdenes;

    private int contadorComputadoras;
    //tamano del arreglo
    private static final int maxComputadora=10;

    public Orden(){
        this.idOrden=++contadorOrdenes;
        computadoras = new Computadora[maxComputadora];
    }
    // se valida y se agrega
    public void agregarComputadora(Computadora computadora){
        if (contadorComputadoras<maxComputadora){
            computadoras[contadorComputadoras++]=computadora;
        }else{
            System.out.println("Se ha superado el maximo de productos: "+maxComputadora);
        }

    }

    public void mostrarOrden(){
        System.out.println("#Orden :"+idOrden);
        System.out.println("Computadoras de la orden #"+idOrden+":");

        for(int i =0; i<contadorComputadoras; i++){
            System.out.println(computadoras[i]);
        }
    }




}
