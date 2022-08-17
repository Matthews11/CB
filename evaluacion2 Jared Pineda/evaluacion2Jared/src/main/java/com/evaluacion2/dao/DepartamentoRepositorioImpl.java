package com.evaluacion2.dao;

import com.evaluacion2.dto.Departamento;
import com.evaluacion2.dto.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoRepositorioImpl implements IRepositorio<Departamento>{

    private Connection con;

    public DepartamentoRepositorioImpl(){}

    @Override
    public void setCon(Connection con) {
        this.con=con;
    }

    @Override
    public List<Departamento> listar() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM departamentos")){
            while (rs.next()){
                departamentos.add(crearDepa(rs));
            }
        } return departamentos;
    }


    @Override
    public Departamento guardar(Departamento departamento) throws SQLException {
        String sql;
        if (departamento.getId()!=null && departamento.getId()>0){
            sql="UPDATE departamentos SET depa=?  WHERE id=?";
        }else {
            sql="INSERT INTO departamentos (depa ) value(?)";
        }
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,departamento.getDepa());

            if (departamento.getId()!=null && departamento.getId()>0){
                ps.setLong(2,departamento.getId());
            }
            ps.executeUpdate();
        }
        return departamento;
    }

    @Override
    public Departamento obtener(Long id) throws SQLException {
        Departamento depa=null;
        try (PreparedStatement ps =con.prepareStatement("SELECT * FROM departamentos WHERE id=?")){
            ps.setLong(1,id);
            try (ResultSet rs=ps.executeQuery()){
                if (rs.next()){
                    depa=crearDepa(rs);
                }
            }
        }
        return depa;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM departamentos WHERE id=?")){
            ps.setLong(1,id);
            ps.executeUpdate();
        }
    }

    private Departamento crearDepa(ResultSet rs) throws SQLException {
        Departamento depa = new Departamento();
        depa.setId(rs.getLong("id"));
        depa.setDepa(rs.getString("depa"));
        return depa;
    }

}
