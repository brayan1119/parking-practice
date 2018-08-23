package co.com.parking.parkingpractice.business.services;

import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;

public interface TarifasService {
	
	public int consultaTarifaDeVehiculo(Integer idTarifa) throws ExceptionTarifaNoEncontrada;

}
