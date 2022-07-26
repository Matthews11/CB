package service;

import Exception.*;
import modelo.Persona;

import java.util.List;

public interface PersonaService {

    void ingresar(Persona persona) throws InsertarEx;
     List<Persona>  listar()throws ListarEx;
}
