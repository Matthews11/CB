package main;

import dao.UsuarioDAO;
import dao.UsuariosDAOJDBC;
import domain.UsuarioDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuariosDAOJDBC();
        UsuarioDTO usuario = new UsuarioDTO();

        usuario.setUsuario("Kraus");
        usuario.setPassword("12345");
        usuario.setMail("kraus@gmail.com");

         UsuarioDTO usuario2 = new UsuarioDTO();
         usuario2.setUsuario("Hashi");
         usuario2.setPassword("123");
         usuario2.setMail("hashi@gmail.com");
        try{
            //inserta
          //  dao.insert(usuario);
         //   dao.insert(usuario2);
            //actualiza
          //    UsuarioDTO usuario3 = new UsuarioDTO();
         //     usuario3.setId(2);
         //     usuario3.setUsuario("||| re");
         //     usuario3.setPassword("123");
         //     usuario3.setMail("re@gmail.com");
        //      dao.update(usuario3);

            //elimina
          //  dao.delete(new UsuarioDTO(2));

            //lista
            List<UsuarioDTO>  usuarios=dao.select();
            for (UsuarioDTO u: usuarios){
                System.out.println(u);
            }
        }catch (SQLException e){
              e.printStackTrace();
        }

    }

}
