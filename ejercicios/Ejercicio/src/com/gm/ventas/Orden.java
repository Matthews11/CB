package com.gm.ventas;

public class Orden {
    private int idOrden;
    private final Producto productos[];
    private static int contador;

    private int contadorProducto;

    private static final int maxProducto=5;

    public Orden(){
        this.idOrden=++contador;
        productos= new Producto[maxProducto];
    }

    public void agregarProducto(Producto producto){

        if (contadorProducto<maxProducto){
            productos[contadorProducto++]=producto;
        }else{
            System.out.println("se supero el maximo"+maxProducto);
        }


    }

    public double calcularTotal(){

        double total =0;
        for (int i =0; i<contadorProducto;i++){
            total+=productos[i].getPrecio();
        }
        return total;
    }

    public void mostrar(){
        System.out.println("orden: "+idOrden);
        System.out.println("total: "+idOrden+": $"+calcularTotal());
        System.out.println("productos de la orden# "+idOrden+"");
        System.out.println("");

        for (int i=0; i<contadorProducto;i++){
            System.out.println(""+productos[i]);
        }
    }

}
