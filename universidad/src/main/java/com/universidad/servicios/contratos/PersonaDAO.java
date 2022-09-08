package com.universidad.servicios.contratos;
 
 
import java.util.Optional; 

import com.universidad.modelo.entidades.Persona;

public interface PersonaDAO  extends GenericDAO<Persona>{ 
	
	Optional<Persona> buscarPorNombreYApellido(String nombre,String apellido);
    
	Optional<Persona> buscarPorDni(String dni);
    
	Iterable<Persona> buscarPersonaPorApellido(String apellido);


}
