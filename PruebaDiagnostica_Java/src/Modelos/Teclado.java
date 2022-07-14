package Modelos;

public class Teclado extends DispositivoEntrada {

	private  int idTeclado;
	private static int contadorTeclados; 

	
	
	public Teclado() {
		super();
	}

	public Teclado(int idTeclado, String tiposEntrada, String marca ) {
		super(tiposEntrada, marca);
		 this.idTeclado=idTeclado;
		 contadorTeclados++;  
	}

	public int getIdTeclado() {
		return idTeclado;
	}
 
	public int getContadorTeclados() {
		return contadorTeclados;
	} 
 
	public void setIdTeclado(int idTeclado) {
		this.idTeclado = idTeclado;
	}

	@Override
	public String toString() {
		return "\nTeclado idTeclado=" + idTeclado +  ", toString()=" + super.toString() + "]";
	}

	 

}
