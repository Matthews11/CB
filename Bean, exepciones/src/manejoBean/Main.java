package manejoBean;

import beans.PersonaBean;

public class Main {
    public static void main(String[] args) {
        PersonaBean bean = new PersonaBean();
        bean.setNombre("Juan");
        bean.setEdad(21);

        System.out.println("El nombre es: "+bean.getNombre());
        System.out.println("La edad es: "+bean.getEdad());
    }
}
