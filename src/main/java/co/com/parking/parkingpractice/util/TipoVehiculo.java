package co.com.parking.parkingpractice.util;

public enum TipoVehiculo {
	
	MOTO("M","Moto", 10), CARRO("C", "Carro", 20);
	
	private String tipo;
	private String nombre;
	private int tope;
	
	private TipoVehiculo(String tipo, String nombre, int tope) {
		this.tipo = tipo;
		this.nombre = nombre;
		this.tope = tope;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTope() {
		return tope;
	}
	
}
