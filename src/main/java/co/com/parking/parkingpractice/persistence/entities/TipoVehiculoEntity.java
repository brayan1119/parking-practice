package co.com.parking.parkingpractice.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tipo_vehiculo")
public class TipoVehiculoEntity {
	
	@Id
	@Column(name = "tipo", nullable = false)
	private String tipo;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "tope", nullable = false)
	private int tope;

	public TipoVehiculoEntity() {
		super();
	}

	public TipoVehiculoEntity(String tipo) {
		super();
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
}
