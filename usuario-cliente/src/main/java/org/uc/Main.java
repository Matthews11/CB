package org.uc;

import org.uws.servicio.IServicio;
import org.uws.servicio.Usuario;
import org.uws.servicio.UsuarioServicioImplService;




public class Main {
    public static void main(String[] args) {
        IServicio is = new UsuarioServicioImplService().getUsuarioServicioImplPort();
        is.listar().forEach(usuarios -> {
            System.out.println(usuarios.getNombre()+"    "+usuarios.getPassword());
        });
        System.out.println(is.obtener(1L));
      //  Usuario usuario = new Usuario();
      //  usuario.setId(1L);
      // usuario.setNombre("hashi");
      //  usuario.setPassword("123");
      //  usuario.setFecha("2022-12-2");
      //  is.obtener(3L);
     //   is.eliminar(3l);


    }
}
