package datos;

import excepciones.*;

public interface AccesoDatos {
    
    void insertar() throws AccesoDatosEx;
    
    void listar() throws AccesoDatosEx;

    void simularError(boolean simular) throws AccesoDatosEx;



    
}
