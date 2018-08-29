package co.com.parking.parkingpractice.models;

import java.util.Date;

import co.com.parking.parkingpractice.util.TipoVehiculo;

public class ConsultaParqueadosDTO {
	
	private String placa;
	private String tipo; // (Carro, Moto)
	private Date fechaIngreso;
	
	
	
	public ConsultaParqueadosDTO(String placa, String tipo, Date fechaIngreso) {
		super();
		this.placa = placa;
		this.tipo = getNombreTipo(tipo);
		this.fechaIngreso = fechaIngreso;
	}
	
	private String getNombreTipo(String tipo) {
		String nombreTipo;
		
		if (TipoVehiculo.MOTO.getTipo().equals(tipo)) {
			nombreTipo = TipoVehiculo.MOTO.getNombre();
		}else {
			nombreTipo = TipoVehiculo.CARRO.getNombre();
		}

		return nombreTipo;
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
