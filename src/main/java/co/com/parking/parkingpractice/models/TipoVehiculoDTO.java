package co.com.parking.parkingpractice.models;

public class TipoVehiculoDTO {
	
	private String tipo;
	private String nombre;
	
	public TipoVehiculoDTO(String tipo, String nombre) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
