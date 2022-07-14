package Principal;

import Modelos.Computadora;
import Modelos.Orden;

public class Main {
	
	public static void main(String[] args) {
		Computadora compu[];
		Orden orden = new Orden();
		double total;
		compu=orden.agregarComputadoras();
		total=orden.calcularTotal(compu);
		orden.mostrarOrden(compu,total);
		
	}

}
