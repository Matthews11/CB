package Exception1.main;

import Exception1.domain.Division;
import Exception1.domain.OperationException;

public class Main2 {
    public static void main(String[] args) {
        try {
            int op1 = Integer.parseInt(args[0]);
            int op2 = Integer.parseInt(args[1]);
            Division div = new Division(op1,op2);
            div.mostrarOperacion();
        }catch (ArrayIndexOutOfBoundsException aiobe){
            System.out.println("Ocurrio una excepcion: ");
            System.out.println("Hubo un error al acceder a un elemento");
            aiobe.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("Ocurio una exceptiom: ");
            System.out.println("Uno de los argumentos no es entero: ");
            nfe.printStackTrace();
        }catch (OperationException oe){
            System.out.println("Ocurio una excepcion");
            System.out.println("Se trato de realizar una operacion erronea");
            oe.printStackTrace();
        }finally{
            System.out.println("Se terminaron de revisar las excepciones");
        }
    }
}
