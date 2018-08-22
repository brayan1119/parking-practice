package co.com.parking.parkingpractice.models;

import co.com.parking.parkingpractice.persistence.entities.VehiculoEntity;

public class VehiculoDTO {
	
    private String placa;
    private String tipo;
    
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
		return entity;
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

	@Override
	public String toString() {
		return "VehiculoDTO [placa=" + placa + ", tipo=" + tipo + "]";
	}

}
