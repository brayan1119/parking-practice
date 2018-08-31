package co.com.parking.parkingpractice.models;

import java.util.Date;


public class ConsultaParqueadosDTO {
	
	private String placa;
	private String tipo; // (Carro, Moto)
	private Date fechaIngreso;
	
	
	
	public ConsultaParqueadosDTO(String placa, String tipo, Date fechaIngreso) {
		super();
		this.placa = placa;
		this.tipo = tipo;
		this.fechaIngreso = fechaIngreso;
	}	

	public String getPlaca() {
		return placa;
	}

	public String getTipo() {
		return tipo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
}
