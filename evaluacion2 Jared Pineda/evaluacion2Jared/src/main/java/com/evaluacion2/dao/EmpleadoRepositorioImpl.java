package com.evaluacion2.dao;

import com.evaluacion2.dto.Departamento;
import com.evaluacion2.dto.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositorioImpl implements IRepositorio<Empleado>{

    private Connection con;

    public EmpleadoRepositorioImpl(){
    }

    @Override
    public void setCon(Connection con) {
        this.con=con;
    }

    @Override
    public List<Empleado> listar() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from empleados as e inner join departamentos as d on (e.idp=d.id)")){
            while (rs.next()){
                empleados.add(crearEmpleado(rs));
            }
        }
        return empleados;
    }

    @Override
    public Empleado guardar(Empleado empleado) throws SQLException {

        String sql;
        if (empleado.getId()!=null && empleado.getId()>0){
            sql="UPDATE empleados SET nombre=?, apellido =?, direccion=?, correo=?, idp=? WHERE id=?";
        }else {
            sql="INSERT INTO empleados (nombre,apellido,direccion,correo,idp) values(?,?,?,?,?)";
        }
        try(PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1,empleado.getNombre());
            ps.setString(2,empleado.getApellido());
            ps.setString(3,empleado.getDireccion());
            ps.setString(4,empleado.getDireccion());
            ps.setLong(5,empleado.getDepa().getId());
            if (empleado.getId()!=null && empleado.getId()>0){
               ps.setLong(6,empleado.getId());
            }
            ps.executeUpdate();
        }
        return empleado;
    }

    @Override
    public Empleado obtener(Long id) throws SQLException {
        Empleado empleado=null;
        try (PreparedStatement ps =con.prepareStatement("select * from empleados as e inner join departamentos as d on (e.idp=d.id) WHERE e.id=?")){
            ps.setLong(1,id);
            try (ResultSet rs=ps.executeQuery()){
                if (rs.next()){
                    empleado=crearEmpleado(rs);
                }
            }
        }
        return empleado;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("DELETE  FROM empleados WHERE id=?")){
            ps.setLong(1,id);
            ps.executeUpdate();
        }
    }


    private Empleado crearEmpleado(ResultSet rs) throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setId(rs.getLong("id"));
        empleado.setNombre(rs.getString("nombre"));
        empleado.setApellido(rs.getString("apellido"));
        empleado.setDireccion(rs.getString("direccion"));
        empleado.setCorreo(rs.getString("correo"));
        Departamento depa = new Departamento();
        depa.setId(rs.getLong("id"));
        depa.setDepa(rs.getString("depa"));
        empleado.setDepa(depa);
        return empleado;
    }


}
