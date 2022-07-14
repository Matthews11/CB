package Modelos;
 

public class Orden {

	private int orden;
	private int contadorOrdenes;  
	
	public Orden() {

		super();
	}

	public Computadora [] agregarComputadoras() { 
	 
		
		Teclado teclado[] = {new Teclado(1,"salida","Hyperx" ),
				new Teclado(2,"salida","logitech" ),new Teclado(3,"salida","red dragon" )}; 
		
		Raton raton []= {new Raton(1,"salida","logitech" ),
				new Raton(2,"salida","hyperx" ),new Raton(3,"salida","lenovo" )}; 
		
		Monitor monitor[] = {new Monitor(1,"dell",24.7,teclado,raton), 
				new Monitor(2,"hp",27.6,teclado,raton)};
		
		Computadora computadora[] = { new Computadora("pc multi tareas",200,monitor,teclado,raton),new Computadora("pc ",200,monitor,teclado,raton)   }; 
		
		return computadora;
	}

	public double calcularTotal(Computadora compu[]) {
		double total=0.0;
		 
		for(int i =0; i<compu.length; i++) {
			total += compu[i].getPrecio(); 
		} 
		return  total;
		
	}

	public void mostrarOrden(Computadora compu[], Double total) {
		
		for(int i=0; i<1; i++) {
			 System.out.println(compu[i]);
			 System.out.println("\t \t \t \t \t \t \t \t \t     el total es: "+total);
		} 
	}

}
