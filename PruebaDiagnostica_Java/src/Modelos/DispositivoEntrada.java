package Modelos;

public class DispositivoEntrada {
	
	private String tiposEntrada;
	private String marca;
	
	
	
	
	public DispositivoEntrada() {
		super();
	}

	public DispositivoEntrada(String tiposEntrada, String marca) {
		this.tiposEntrada = tiposEntrada;
		this.marca = marca;
	}

	public String getTiposEntrada() {
		return tiposEntrada;
	}

	public void setTiposEntrada(String tiposEntrada) {
		this.tiposEntrada = tiposEntrada;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "DispositivoEntrada=" + tiposEntrada + ", marca=" + marca + "";
	}

	 
	
	
	
	

}
