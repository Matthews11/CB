package Modelos;

public class Monitor {
	
	private  int idMonitor;
	private String Marca;
	private Double tamano;
	private static int contadorMonitor;
	private Teclado teclado[];
	private Raton raton[];
	
	
	public Monitor() {
		super();
	}   

	 
	public Monitor(int idMonitor,String marca, Double tamano, Teclado teclado[], Raton raton[]) {
		super();
		 
		contadorMonitor++;
		this.Marca = marca;
		this.tamano = tamano; 
		this.teclado = teclado;
		this.raton = raton;
		this.idMonitor=idMonitor;
		 
	}

 
	public void setIdMonitor(int idMonitor) {
		this.idMonitor = idMonitor;
	}


	public int getIdMonitor() {
		return idMonitor;
	}
 
	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public Double getTamano() {
		return tamano;
	}

	public void setTamano(Double tamano) {
		this.tamano = tamano;
	}

	public int getContadorMonitor() {
		return contadorMonitor;
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
		return "\nMonitor [idMonitor=" + idMonitor + ", Marca=" + Marca + ", tamano=" + tamano +  "]";
	}


	 

	 
	
	
	
	
	
	
	
	

}
