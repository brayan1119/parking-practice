package co.com.parking.parkingpractice.models;

import java.util.Date;

public class VehiculoDTO {
	
    private String placa;
    private String tipo;
    private int cilindraje;
    private Date fechaIngreso;
    private Date fechaSalida;
    
    public VehiculoDTO() {
    	super();
    }
    
	public VehiculoDTO(String placa, String tipo) {
		super();
		this.tipo = tipo;
		this.placa = placa;
	}
	
	public VehiculoDTO(String placa, String tipo, int cilindraje, Date fechaIngreso, Date fechaSalida) {
		super();
		this.placa = placa;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
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

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

}
