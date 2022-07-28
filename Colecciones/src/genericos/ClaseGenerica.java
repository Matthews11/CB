package genericos;

public class ClaseGenerica <T>{
    T objeto;

    public ClaseGenerica(T objeto) {
        this.objeto = objeto;
    }

    public void obtener(){
        System.out.println("El tipo T es: "+objeto.getClass().getName());
    }
}
