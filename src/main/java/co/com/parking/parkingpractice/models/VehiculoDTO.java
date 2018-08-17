package co.com.parking.parkingpractice.models;

import co.com.parking.parkingpractice.persistence.entities.VehiculoEntity;

public class VehiculoDTO {
	
    private Integer id;
    private String placa;
    
    public VehiculoDTO() {
    	super();
    }
    
	public VehiculoDTO(Integer id, String placa) {
		super();
		this.id = id;
		this.placa = placa;
	}

	public VehiculoDTO(VehiculoEntity entity) {
		super();
		this.id = entity.getId();
		this.placa = entity.getPlaca();
	}

	public VehiculoEntity convertVehiculoToEntity() {
		VehiculoEntity entity = new VehiculoEntity();
		entity.setId(this.getId());
		entity.setPlaca(this.getPlaca());
		return entity;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		return "VehiculoDTO [id=" + id + ", placa=" + placa + "]";
	}

    
}
