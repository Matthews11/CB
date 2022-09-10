package com.universidad.servicio.implementaciones;

import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;
import com.universidad.repositorios.AulaRepositorio;
import com.universidad.servicio.contratos.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AulaDAOImpl extends GenericDAOImpl<Aula, AulaRepositorio>implements AulaDAO{
    @Autowired
    public AulaDAOImpl(AulaRepositorio rep) {
        super(rep);
    }

    @Override
    public Iterable<Aula> findAulaByPizarron(Pizarron pizarron) {
        return rep.findAulaByPizarron(pizarron);
    }

    @Override
    public Iterable<Aula> findAulaByPabellonNombre(String nombre) {
        return rep.findAulaByPabellonNombre(nombre);
    }

    @Override
    public Iterable<Aula> findAulaByNroAula(Integer nro) {
        return rep.findAulaByNroAula(nro);
    }
}
