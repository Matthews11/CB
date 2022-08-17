package com.evaluacion2.servicio;

import com.evaluacion2.dto.Departamento;
import com.evaluacion2.dto.Empleado;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IAdministracionServicio {
    List<Departamento> listarD() throws SQLException;
    Departamento guardarD(Departamento departamento)throws SQLException;
    Departamento obtenerD (Long id)throws SQLException;
    void eliminarD(Long id)throws SQLException;

    List<Empleado> listarP() throws SQLException;
    Empleado guardarP(Empleado empleado)throws SQLException;
    Empleado obtenerP(Long id)throws SQLException;
    void eliminarP(Long id)throws SQLException;

}
