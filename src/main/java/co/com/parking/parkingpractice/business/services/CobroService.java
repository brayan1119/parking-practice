package co.com.parking.parkingpractice.business.services;

import java.util.Date;

import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.models.VehiculoDTO;

public interface CobroService {

	public int calcularCobroVehiculo(VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada;

	int calcularHorasParaCobrar(double horas, VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada;

	double diferenciaTiempoHoras(Date fechaInicio, Date fechaFin);
}
