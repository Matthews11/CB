package com.app;

import com.app.domain.ClienteDto;
import com.app.entity.Cliente;
import com.app.util.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

public class QL {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("==========Consultar todos==========");
        List<Cliente> clientes =  em.createQuery("select c from Cliente c ",Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("===========consultar por id========");
        Cliente cliente = em.createQuery("select c from Cliente c where c.id=:id",Cliente.class)
                .setParameter("id",1L).getSingleResult();
        System.out.println(cliente);

        System.out.println("===========consultar el nombre por id========");
        String nombre = em.createQuery("select c.nombre from Cliente c where c.id=:id",String.class)
                .setParameter("id",2L).getSingleResult();
        System.out.println(nombre);

        System.out.println("============= consultar por campos personalizados");
        Object[] oc = em.createQuery("select c.id, c.nombre, c.apellido " +
                "from Cliente c WHERE c.id=:id",Object[].class).setParameter("id",1L).getSingleResult();
        Long id = (Long) oc[0];
        String nombre1 = (String) oc[1];
        String apellido = (String) oc[2];
        System.out.println("id "+id+ " nombre"+nombre1 +" apellido"+apellido );

        System.out.println("============= consultar por campos personalizados lista");
        List< Object[]>  ocs = em.createQuery("select c.id, c.nombre, c.apellido " +
                "from Cliente c ",Object[].class).getResultList();
        ocs.forEach(reg->{
        Long id2 = (Long) reg[0];
        String nombre2 = (String) reg[1];
        String apellido2 = (String) reg[2];
            System.out.println("id "+id2+ " nombre"+nombre2 +" apellido"+apellido2 );
        });

        System.out.println("============= consulta que puebla un objeto entity de una clase personalizada");
        clientes  = em.createQuery("select new Cliente(c.id,c.nombre, c.apellido,c.formaPago )" +
                "from Cliente c ",Cliente.class).getResultList();
        clientes.forEach(System.out::println);


        System.out.println("============= consulta que puebla otro entity de una clase personalizada");
        List<ClienteDto> clienteDtos = em.createQuery("select new com.app.domain.ClienteDto(c.nombre,c.apellido) from " +
                "Cliente c ",ClienteDto.class).getResultList();
        clienteDtos.forEach(System.out::println);

        System.out.println("Consulta con nombre de cliente");
        List<String> nombres = em.createQuery("select c.nombre from Cliente c",String.class).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("Consulta nombres unicos");
        nombres=em.createQuery("select distinct (c.nombre) from Cliente c",String.class ).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("Consulta formade pago unicos");
        List<String> forma=em.createQuery("select distinct (c.formaPago) from Cliente c",String.class ).getResultList();
        forma.forEach(System.out::println);

        System.out.println("consulta con numero de pago unica");
        Long total =em.createQuery("select count (c.formaPago) from Cliente  c",Long.class).getSingleResult();
        System.out.println(total);

        System.out.println("Nombre y apellido concatenados");
        nombres=em.createQuery("select c.nombre||''||c.apellido as nombreCompleto from Cliente  c",String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("Nombre y apellido concatenados en mayuscula");
        nombres=em.createQuery("select upper(concat(c.nombre,'',c.apellido) ) as nombreCompleto from Cliente  c",String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("consulta para buscar por nombre");
        String param = "NA";
        clientes=em.createQuery("select c from Cliente c where upper(c.nombre) like upper(:parametro) ",Cliente.class)
                .setParameter("parametro",param)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("Consulta por rango");
        clientes = em.createQuery("select c from Cliente  c where c.nombre between 'J' and 'Q'",Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("consulta con orden");
        clientes=em.createQuery("select c from Cliente c order by c.nombre asc, c.apellido asc ",Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("consulta con total de regitros");
        Long totalR = em.createQuery("select count(c) as total from Cliente c",Long.class).getSingleResult();
        System.out.println(totalR);

        System.out.println("Consulta con valor minimo del id");
        Long miId=em.createQuery("select min(c.id) as minimo from Cliente c ",Long.class).getSingleResult();
        System.out.println(miId);

        System.out.println("Consulta con max / ultimo id");
        Long maxid=em.createQuery("select max (c.id) as maximo from Cliente  c",Long.class).getSingleResult();
        System.out.println(maxid);

        System.out.println("consulta nombre con su largo");
        ocs=em.createQuery("select c.nombre, length(c.nombre) from Cliente c",Object[].class).getResultList();
        ocs.forEach(oo ->{
            String nom = (String) oo[0];
            Integer largo = (Integer) oo[1];
            System.out.println("nombre="+nom+" largo="+largo);
        });

        System.out.println("nombre mas corto");
        Integer minLargoNom=em.createQuery("select min(length(c.nombre) ) from Cliente c",Integer.class).getSingleResult();
        System.out.println(minLargoNom);

        System.out.println("nombre mas largo");
        Integer maxLargoNom=em.createQuery("select max(length(c.nombre) ) from Cliente c",Integer.class).getSingleResult();
        System.out.println(maxLargoNom);

        System.out.println("consulta resumen de funciones agregacion count mix etc");
        Object[] estadistica = em.createQuery("select min(c.id), max(c.id), sum(c.id),count(c.id)" +
                ", avg (length(c.nombre)) from Cliente c", Object[].class).getSingleResult();
        Long min = (Long) estadistica[0];
        Long max = (Long) estadistica[1];
        Long sum = (Long) estadistica[2];
        Long count = (Long) estadistica[3];
        Double avr = (Double) estadistica[4];
        System.out.println("min "+min+" max "+max+" sum"+sum+" count"+count+ "avr"+avr);

        System.out.println("consulta nombre corto y largo");
        ocs=em.createQuery("select c.nombre, length(c.nombre) from Cliente c where length(c.nombre) =(select min (length(c.nombre) ) from Cliente c)",Object[].class)
                .getResultList();
        ocs.forEach(asd->{
            String nom= (String) asd[0];
            Integer largo= (Integer) asd[1];
            System.out.println("nombre= "+nom+" largo"+largo);
        });

        System.out.println("consulta par obtener el ultimo registro");
        Cliente ultimo = em.createQuery("select c from Cliente c where c.id=(select max(c.id) " +
                        "from Cliente c)",Cliente.class).getSingleResult();
        System.out.println(ultimo);

        System.out.println("consulta where in");
        clientes=em.createQuery("select c from Cliente c where c.id in :ids",Cliente.class)
                .setParameter("ids", Arrays.asList(1L,2L,10L,6L))
                .getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}
