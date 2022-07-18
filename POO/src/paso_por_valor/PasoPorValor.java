package paso_por_valor;

public class PasoPorValor {

    public static void main(String[] args) {
        int x = 10;
        imprimir(x);
        cambiarValor(x);
        imprimir(x);

    }

    public static void cambiarValor(int i){
      //  System.out.println("valor pasado: "+i);
        i=200;
        //System.out.println("valor convertido: "+i);
    }

    public static void imprimir(int arg){
        System.out.println("valor recibido: "+arg);
    }

}
