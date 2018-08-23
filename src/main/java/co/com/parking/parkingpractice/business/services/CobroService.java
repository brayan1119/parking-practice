package co.com.parking.parkingpractice.business.services;

import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.models.VehiculoDTO;

public interface CobroService {

	public int calcularCobroVehiculo(VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada;
}
