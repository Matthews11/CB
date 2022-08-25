package org.admin.cliente;

import org.administracion.servicio.AdministracionServicio;
import org.administracion.servicio.AdministracionServicioImplService;
import org.administracion.servicio.Rol;
import org.administracion.servicio.Usuario;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws DatatypeConfigurationException {
        AdministracionServicio as = new AdministracionServicioImplService().getAdministracionServicioImplPort();
     //   System.out.println("insertando");
     //   Rol rol = new Rol();
     //   rol.setId(2L);
     //   rol.setRol("asd");
     //   as.guardarRol(rol);

      //  System.out.println("listando");
      //  as.listarRol().forEach(roll -> {
      //      System.out.println("id= "+roll.getId()+ ", rol= "+roll.getRol());
      //  });

      //  System.out.println("obteniendo");
      //  Rol rola= as.obtenerRol(1L);
      //  System.out.println(rola.getRol());
      //  System.out.println("eliminando");
       // as.eliminarRol(4L);



        /*Usuario usuario = new Usuario();
        Rol rol = new Rol();
        usuario.setNombre("jared");
        usuario.setContrasena("1234");
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(2022,12,1,1,20,21,21,22);
        usuario.setFecha(date2);
        rol.setId(1L);
        usuario.setRole(rol);
        as.guardarUsuario(usuario);

        as.listarUsuario().forEach(usuarios -> {
            System.out.println("usuario: "+usuarios.getNombre()+", rol: "+usuarios.getRole().getRol());
        });

        //as.eliminarUsuario(6l);

*/
        Usuario usuario = new Usuario();
        Rol rol = new Rol();
        usuario.setId(9L);
        usuario.setNombre("kraus");
        usuario.setContrasena("1234");
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(2022,12,1,1,20,21,21,22);
        usuario.setFecha(date2);
        rol.setId(1L);
        usuario.setRole(rol);
        as.guardarUsuario(usuario);

        as.listarUsuario().forEach(usuarios -> {
            System.out.println("usuario: "+usuarios.getNombre()+", rol: "+usuarios.getRole().getRol());
        });
    }
}
