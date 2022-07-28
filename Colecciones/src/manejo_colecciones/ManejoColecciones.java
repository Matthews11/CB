package manejo_colecciones;

import java.util.*;

public class ManejoColecciones {
    public static void main(String[] args) {
        List lista = new ArrayList();
        lista.add("1");
        lista.add("2");
        lista.add("3");
        lista.add("4");
        //elemento repetido
        lista.add("4");
        imprimir(lista);


        Set set = new HashSet();
        set.add("100");
        set.add("200");
        set.add("300");
        //elemento repetido
        set.add("300");
        imprimir(set);

        Map map = new HashMap();
        map.put("1","juan");
        map.put("2","calo");
        map.put("3","rosario");
        map.put("4","esperanza");

        imprimir(map.keySet());
        imprimir(map.values());

    }

    public static void imprimir(Collection coleccion){
        for (Object elemento: coleccion){
            System.out.println(elemento+" ");
        }
    }
}
