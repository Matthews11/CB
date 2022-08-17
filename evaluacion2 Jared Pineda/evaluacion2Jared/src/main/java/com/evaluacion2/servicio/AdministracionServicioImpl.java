package com.evaluacion2.servicio;

import com.evaluacion2.dao.Conexion;
import com.evaluacion2.dao.DepartamentoRepositorioImpl;
import com.evaluacion2.dao.EmpleadoRepositorioImpl;
import com.evaluacion2.dao.IRepositorio;
import com.evaluacion2.dto.Departamento;
import com.evaluacion2.dto.Empleado;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministracionServicioImpl implements IAdministracionServicio{
    private IRepositorio<Departamento> departamentoIRepositorio;
    private IRepositorio<Empleado> empleadoIRepositorio;


    public AdministracionServicioImpl() throws SQLException {
        this.departamentoIRepositorio= new DepartamentoRepositorioImpl();
        this.empleadoIRepositorio= new EmpleadoRepositorioImpl();

    }

    @Override
    public List<Departamento> listarD() throws SQLException {
        Connection con = Conexion.getConnection();
        List<Departamento> departamentos = new ArrayList<>();
        try {
            departamentoIRepositorio.setCon(con);
            departamentos= departamentoIRepositorio.listar();

        }catch (SQLException e){
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }finally {
            con.close();
        }
        return departamentos;
    }

    @Override
    public Departamento guardarD(Departamento departamentos) throws SQLException {
        Connection con = Conexion.getConnection();
        Departamento nuevoDepa=null;
        try {
            departamentoIRepositorio.setCon(con);
            if (con.getAutoCommit()){
                con.setAutoCommit(false);
            }
            nuevoDepa=departamentoIRepositorio.guardar(departamentos);
            con.commit();
            System.out.println("Se realizo la consulta con exito");
        }catch (SQLException e){
            System.out.println("Ocurrio un error");
            System.out.println("Rollback");
            con.rollback();
            e.printStackTrace();
        }finally {
            con.close();
        }
        return nuevoDepa ;
    }

    @Override
    public Departamento obtenerD(Long id) throws SQLException {
        Connection con = Conexion.getConnection();
        Departamento nuevoDepa=null;
        try {
            departamentoIRepositorio.setCon(con);
            nuevoDepa= departamentoIRepositorio.obtener(id);
        }catch (SQLException e){
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }finally {
            con.close();
        }
        return nuevoDepa;
    }

    @Override
    public void eliminarD(Long id) throws SQLException {
        Connection con = Conexion.getConnection();
        try {
            departamentoIRepositorio.setCon(con);
            if (con.getAutoCommit()){
                con.setAutoCommit(false);
            }
            departamentoIRepositorio.eliminar(id);
            con.commit();
            System.out.println("Se elimino con exito");
        }catch (SQLException e){
            System.out.println("Ocurrio un error");
            System.out.println("Rollback");
            con.rollback();
            e.printStackTrace();
        }finally {
            con.close();
        }
    }

    @Override
    public List<Empleado> listarP() throws SQLException {
        Connection con = Conexion.getConnection();
        List<Empleado> empleados = new ArrayList<>();
        try {
            empleadoIRepositorio.setCon(con);
            empleados= empleadoIRepositorio.listar();

        }catch (SQLException e){
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }finally {
            con.close();
        }
        return empleados;
    }

    @Override
    public Empleado guardarP(Empleado empleado) throws SQLException {
        Connection con = Conexion.getConnection();
        Empleado nuevoEm=null;
        try {
            empleadoIRepositorio.setCon(con);
            if (con.getAutoCommit()){
                con.setAutoCommit(false);
            }
            nuevoEm=empleadoIRepositorio.guardar(empleado);
            con.commit();
            System.out.println("Se realizo la consulta con exito");
        }catch (SQLException e){
            System.out.println("Ocurrio un error");
            System.out.println("Rollback");
            con.rollback();
            e.printStackTrace();
        }finally {
            con.close();
        }
        return nuevoEm ;
    }

    @Override
    public Empleado obtenerP(Long id) throws SQLException {
        Connection con = Conexion.getConnection();
        Empleado nuevoEm=null;
        try {
            empleadoIRepositorio.setCon(con);
            nuevoEm= empleadoIRepositorio.obtener(id);
        }catch (SQLException e){
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }finally {
            con.close();
        }
        return nuevoEm;
    }

    @Override
    public void eliminarP(Long id) throws SQLException {
        Connection con = Conexion.getConnection();
        try {
            empleadoIRepositorio.setCon(con);
            if (con.getAutoCommit()){
                con.setAutoCommit(false);
            }
            empleadoIRepositorio.eliminar(id);
            con.commit();
            System.out.println("Se elimino con exito");
        }catch (SQLException e){
            System.out.println("Ocurrio un error");
            System.out.println("Rollback");
            con.rollback();
            e.printStackTrace();
        }finally {
            con.close();
        }
    }


}
