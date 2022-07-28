package datos;

import excepciones.*;

public class ImplementacionMySql implements AccesoDatos {

    private boolean simular;

    public boolean isSimular() {
        return simular;
    }

    @Override
    public void insertar() throws AccesoDatosEx  {

        if (simular){
            throw new EscrituraDatosEx("Error de escritura de datos");
        }else {
            System.out.println("Insertar desde MySql");
        }

    }

    @Override
    public void listar() throws AccesoDatosEx  {

        if (simular){
           throw new ExcepcionLecturaDatos("Error de lectura de datos ");
        }

            System.out.println("Listar desde MySql");
    }

    @Override
    public void simularError(boolean simular) throws AccesoDatosEx {
        this.simular= simular;
    }
}
