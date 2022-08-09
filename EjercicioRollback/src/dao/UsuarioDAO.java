package dao;

import domain.UsuarioDTO;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    int insert(UsuarioDTO usuarioDTO)throws SQLException;

    int update(UsuarioDTO usuarioDTO)throws SQLException;

    int delete(UsuarioDTO usuarioDTO)throws SQLException;

    List<UsuarioDTO> select()throws SQLException;

}
