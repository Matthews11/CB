package com.universidad.servicio.contratos;

import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;

public interface AulaDAO extends GenericDAO<Aula>{
    Iterable<Aula>findAulaByPizarron(Pizarron pizarron);

    Iterable<Aula>findAulaByPabellonNombre(String nombre);

    Iterable<Aula>findAulaByNroAula(Integer nro);
}
