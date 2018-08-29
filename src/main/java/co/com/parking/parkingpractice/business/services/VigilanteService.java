package co.com.parking.parkingpractice.business.services;

import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.models.SalidaVehiculoDTO;
import co.com.parking.parkingpractice.models.VehiculoDTO;

public interface VigilanteService {
	
	public void ingresaVehiculo(VehiculoDTO vehiculo) throws ExcepcionGenerica;

	SalidaVehiculoDTO salirVehiculo(VehiculoDTO vehiculo) throws ExcepcionGenerica;

}
