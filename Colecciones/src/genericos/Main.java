package genericos;

public class Main {
    public static void main(String[] args) {
        ClaseGenerica<Integer> objetoI = new ClaseGenerica(15);
        objetoI.obtener();

        ClaseGenerica<String> objetoS = new ClaseGenerica("prueba");
        objetoS.obtener();

    }
}
