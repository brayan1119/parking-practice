package co.com.parking.parkingpractice.business.services;

import java.util.List;

import co.com.parking.parkingpractice.ecxceptions.ExceptionSalidaNoRegistrada;
import co.com.parking.parkingpractice.models.ConsultaParqueadosDTO;
import co.com.parking.parkingpractice.models.VehiculoDTO;

public interface VehiculoService {
	
	public void ingresarVehiculo(VehiculoDTO vehiculo);
	
	public int contarVehiculoXTipo(String tipo);
	
	public boolean validarVehiculoEstaAdentro(String placa);

	public void actualizarSalidaVehiculo(VehiculoDTO vehiculo) throws ExceptionSalidaNoRegistrada;

	public List<ConsultaParqueadosDTO> obtenerVehiculosParqueados();

	public VehiculoDTO obtenerVehiculoXPlaca(String placa);

}
