package co.com.parking.parkingpractice.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.parking.parkingpractice.business.services.VehiculoService;
import co.com.parking.parkingpractice.business.services.VigilanteService;
import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.util.MensajesUtil;
import co.com.parking.parkingpractice.util.VehiculoUtil;

public class VigilanteServiceImpl implements VigilanteService {

	@Autowired
	private VehiculoService vehiculoService;
	
	@Override
	public void ingresaVehiculo(VehiculoDTO vehiculo) throws ExcepcionGenerica {
		
		int numVehiculo = vehiculoService.contarVehiculoXTipo(vehiculo.getTipo());
		boolean hayEspacioVehiculo = numVehiculo <= VehiculoUtil.tipoVehiculo(vehiculo.getTipo()).getTope();
		boolean puedeEntrarPorDigitoYDia = VehiculoUtil.puedeEntrarPorDigitoYDia(vehiculo.getPlaca());
		if (hayEspacioVehiculo && puedeEntrarPorDigitoYDia) {
			vehiculoService.insertarVehivculo(vehiculo);
		}else if(!hayEspacioVehiculo){
			throw new ExcepcionGenerica(MensajesUtil.MENSAJE_NO_HAY_ESPACIO);
		}else {
			throw new ExcepcionGenerica(MensajesUtil.MENSAJE_VEHICULO_NO_INGRESA);
		}
		
	}

}
