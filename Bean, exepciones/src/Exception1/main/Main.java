package Exception1.main;

import Exception1.domain.*;

public class Main {
    public static void main(String[] args)  {

        try {
            Division div = new Division(12,0);
             div.mostrarOperacion();
     }  catch (OperationException oe){
             System.out.println("Ocurrio un error pa");
             oe.printStackTrace();
         }
    }
}
