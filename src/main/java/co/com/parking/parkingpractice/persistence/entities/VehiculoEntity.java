package co.com.parking.parkingpractice.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "vehiculo")
public class VehiculoEntity {
    
	@Id
    @Column(name = "placa", nullable = false, unique = true)
    private String placa;
    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo")
    private TipoVehiculoEntity tipo;
    
    @Column(name = "cilindraje", nullable = false)
    private int cilindraje;

    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    
    @Column(name = "fecha_salida", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVehiculoEntity getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculoEntity tipo) {
		this.tipo = tipo;
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
