package matrices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Persona personas [][]=new Persona[3][2];

        personas[0][0]= new Persona("jared");
        personas[0][1]= new Persona("calo");
        personas[1][0]= new Persona("juan");
        personas[1][1]= new Persona("alfrego");
        personas[2][0]= new Persona("gerson");
        personas[2][1]= new Persona("miguel");


        for (int i=0; i< personas.length;i++){
            for (int j = 0; j < personas[i].length; j++) {
                System.out.println("Matriz personas indice: "+i+" - "+j+": "+personas[i][j].getNombre());
            }
        }

        String nombres[] []= {{"tereza","cesar","wlliam","esteban"}};
        System.out.println("");
        System.out.println("largo matriz renglones"+nombres.length);
        System.out.println("largo matriz columnas"+nombres[0].length);
        System.out.println("");


        for (int i=0; i< nombres.length;i++){
            for (int j = 0; j < nombres[i].length; j++) {
                System.out.println("Matriz nombre indice: "+i+" - "+j+": "+personas[i][j].getNombre());
            }
        }

    }
}
