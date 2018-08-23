package co.com.parking.parkingpractice.business.services;

import co.com.parking.parkingpractice.ecxceptions.ExceptionVehiculoParqueado;
import co.com.parking.parkingpractice.ecxceptions.ExceptionSalidaNoRegistrada;
import co.com.parking.parkingpractice.models.VehiculoDTO;

public interface VehiculoService {
	
	public void insertarVehivculo(VehiculoDTO vehiculo);
	
	public int contarVehiculoXTipo(String tipo);
	
	public boolean validarVehiculoEstaAdentro(String placa) throws ExceptionVehiculoParqueado;

	void actualizarSalidaVehiculo(VehiculoDTO vehiculo) throws ExceptionSalidaNoRegistrada;

	void obtenerVehiculosParqueados();

}
