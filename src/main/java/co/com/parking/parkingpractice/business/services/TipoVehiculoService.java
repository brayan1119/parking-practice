package co.com.parking.parkingpractice.business.services;

import java.util.List;

import co.com.parking.parkingpractice.models.TipoVehiculoDTO;

public interface TipoVehiculoService {

	public int capacidadPorTipo(String tipo);
	
	public List<TipoVehiculoDTO> obtenerTiposVehiculos();

}
