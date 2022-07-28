package manejointerfaces;

import datos.*;
import excepciones.*;

public class ManejoInterfaces {

    public static void main(String[] args) throws AccesoDatosEx {
        AccesoDatos  datos = new ImplementacionMySql();
        datos.simularError(true);
        ejecutar(datos,"listar");

        datos.simularError(false);
        System.out.println("");
        ejecutar(datos,"insertar");
    }
    
    private static void ejecutar  (AccesoDatos datos, String accion){
        if("listar".equals(accion)){
            try{
                datos.listar();
            }catch(ExcepcionLecturaDatos el){
                System.out.println("Error lectura: Procesa la excepcion mas"+
                        " especifica de lectura de datos");
            }catch(AccesoDatosEx ad){
                System.out.println("Error acceso datos: Procesa la exception "+
                        " mas generica de acceso datos");
            }catch(Exception e){
                System.out.println("Error general");
            } finally{
                System.out.println("Procesa finally es opcional, siempre"+
                        "se ejecutara sin importar el error que hubo");
            }
        }else if ("insertar".equals(accion)){
            try {
                datos.insertar();
            }catch(AccesoDatosEx e){
                System.out.println("Error acceso datos se procesa la excepcion mas generica");
            }finally{
                System.out.println("Procesa finally es opcional, siempre"+
                        "se ejecutara sin importar el error que hubo");
            }
        }else {
            System.out.println("No se proporciono niguna accion conocida");
        }
    }
    
}
