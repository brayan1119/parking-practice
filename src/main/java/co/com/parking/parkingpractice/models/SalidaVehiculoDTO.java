package co.com.parking.parkingpractice.models;

import java.util.Date;

public class SalidaVehiculoDTO {
	
	private Date fechaIngreso;
	private Date fechaSalida;
	private int montoCancelar;
	private String placa;
	
	public SalidaVehiculoDTO() {
		super();
	}
	
	public SalidaVehiculoDTO(VehiculoDTO vehiculo) {
		super();
		this.fechaIngreso = vehiculo.getFechaIngreso();
		this.fechaSalida = vehiculo.getFechaSalida();
		this.placa = vehiculo.getPlaca();
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public int getMontoCancelar() {
		return montoCancelar;
	}
	public void setMontoCancelar(int montoCancelar) {
		this.montoCancelar = montoCancelar;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
