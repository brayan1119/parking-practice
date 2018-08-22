package co.com.parking.parkingpractice.business.services;

import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.models.VehiculoDTO;

public interface VehiculoService {
	
	public void insertarVehivculo(VehiculoDTO vehiculo) throws ExcepcionGenerica;
	
	public int contarVehiculoXTipo(String tipo);

}
