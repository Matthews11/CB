package Modelos;

public class Raton extends DispositivoEntrada{
	
	private  int idRaton;
	private static int contadorRatones; 
	 
 
	public Raton() {
		super();
	}

	public Raton(int idRaton,String tiposEntrada, String marca ) {
		super(tiposEntrada, marca);
		this.idRaton= idRaton;
		contadorRatones++;
		 
	}

	public void setIdRaton(int idRaton) {
		this.idRaton = idRaton;
	}

	public int getIdRaton() {
		return idRaton;
	}


	public int getContadorRatones() {
		return contadorRatones;
	}
  

	@Override
	public String toString() {
		return "\nRaton idRaton=" + idRaton 
				+ ", toString()=" + super.toString() + "";
	}

	 
	
	
	
	

}
