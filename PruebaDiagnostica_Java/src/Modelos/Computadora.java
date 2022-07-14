package Modelos;

import java.util.Arrays;

public class Computadora {
	// propiedades
	private static int idComputadora;
	private static int contador;
	private String nombre;
	private Monitor monitor[];
	private Teclado teclado[];
	private Raton raton[];
	private int precio;

	// constructores

	

	public Computadora() {
		super();
	}

	public Computadora( String nombre, int precio,Monitor monitor[], Teclado teclado[], Raton raton[]) {
		super();
		idComputadora++;
		contador++;
		this.nombre = nombre;
		this.precio = precio;
		this.monitor = monitor;
		this.teclado = teclado;
		this.raton = raton;
	}

	// getter y setter
	public int getIdComputadora() {
		return idComputadora;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	 

	public int getContador() {
		return contador;
	}
 

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Monitor[] getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor[] monitor) {
		this.monitor = monitor;
	}

	public Teclado[] getTeclado() {
		return teclado;
	}

	public void setTeclado(Teclado[] teclado) {
		this.teclado = teclado;
	}

	public Raton[] getRaton() {
		return raton;
	}

	public void setRaton(Raton[] raton) {
		this.raton = raton;
	}

	@Override
	public String toString() {
		return "Computadora nombre=" + nombre + "\n monitor=" + Arrays.toString(monitor) + "\n teclado="
				+ Arrays.toString(teclado) + "\n raton=" + Arrays.toString(raton) + "\n \t \t \t \t \t \t \t \t \t \t   precio=" + precio + "";
	}

	
	 

	//return "* Id de la computadora: " + idComputadora + ", Cantidad de computadoras: " + contador + ", Nombre: " + nombre
			//	+ "\n* Id del monitor: "+monitor.getIdMonitor()+", Cantidad de monitores: " + monitor.getContadorMonitor() +", Tamano del monitor: "+monitor.getTamano()+", Marca del monitor: "+monitor.getMarca()
			//	+ "\n* Id del teclado: "+teclado.getIdTeclado()+ ", Cantidad de teclados: " + teclado.getContadorTeclados() +", Marca del teclado: "+teclado.getMarca()+", Tipo de periferico: "+teclado.getTiposEntrada()
			//	+ "\n* Id del raton: "+raton.getIdRaton()+ ", Cantidad de ratones: " + raton.getContadorRatones() +", Marca del raton: "+raton.getMarca()+", Tipo de periferico: "+raton.getTiposEntrada()
	//			+ "\n* \t \t \t \t \t \t \t \t \t \t  precio: " + precio+"";
	 
	
	

}
