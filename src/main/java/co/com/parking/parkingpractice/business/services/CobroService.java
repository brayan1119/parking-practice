package co.com.parking.parkingpractice.business.services;

import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.models.VehiculoDTO;

public interface CobroService {

	public int calcularCobroVehiculo(VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada;

	public int calcularHorasParaCobrar(double horas, VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada;

	/*
	 * Este metodo no debe de pertenecer a la interfaz pues no tiene que ver con su desripcion
	 */
	//public double diferenciaTiempoHoras(Date fechaInicio, Date fechaFin);
}
