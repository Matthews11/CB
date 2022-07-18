package aritmetica;

public class Main {
    public static void main(String[] args) {

        int a=6;
        int b=2;

        Aritmetica obj1 = new Aritmetica(a,b);

        System.out.println("Operando A: "+a+" y opeando B: "+b);
        System.out.println("\n Resultado de la suma:"+obj1.sumar());
        System.out.println("\n Resultado de la resta:"+obj1.restar());
        System.out.println("\n Resultado de la multiplicacion:"+obj1.multiplicar());
        System.out.println("\n Resultado de la division:"+obj1.dividir());
    }

   /* void otroMetodo(){
        System.out.println("Valor de la A: "+a);
    }
    */

}
