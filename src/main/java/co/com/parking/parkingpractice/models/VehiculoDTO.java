package co.com.parking.parkingpractice.models;

import java.util.Date;

import co.com.parking.parkingpractice.persistence.entities.VehiculoEntity;

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

	public VehiculoEntity convertVehiculoToEntity() {
		VehiculoEntity entity = new VehiculoEntity();
		entity.setTipo(this.getTipo());
		entity.setPlaca(this.getPlaca());
		entity.setFechaIngreso(this.getFechaIngreso());
		entity.setFechaSalida(this.getFechaSalida());
		entity.setCilindraje(this.getCilindraje());
		return entity;
	}
	
	public VehiculoDTO(VehiculoEntity vehiculoEntity) {
		super();
		this.placa = vehiculoEntity.getPlaca();
		this.tipo = vehiculoEntity.getTipo();
		this.cilindraje = vehiculoEntity.getCilindraje();
		this.fechaIngreso = vehiculoEntity.getFechaIngreso();
		this.fechaSalida = vehiculoEntity.getFechaSalida();
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
