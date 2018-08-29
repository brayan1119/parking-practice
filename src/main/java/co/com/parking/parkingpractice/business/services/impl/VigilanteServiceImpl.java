package co.com.parking.parkingpractice.business.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.parkingpractice.business.services.CobroService;
import co.com.parking.parkingpractice.business.services.VehiculoService;
import co.com.parking.parkingpractice.business.services.VigilanteService;
import co.com.parking.parkingpractice.constantes.MensajesConstantes;
import co.com.parking.parkingpractice.ecxceptions.ExceptionSalidaNoRegistrada;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.ecxceptions.ExceptionVehiculoParqueado;
import co.com.parking.parkingpractice.ecxceptions.ExecptionCampoInvalido;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoHayEspacioTipoVehiculo;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoPuedeIngresarProresticcionPlacaDia;
import co.com.parking.parkingpractice.ecxceptions.ExecptionVehiculoNoPaqueado;
import co.com.parking.parkingpractice.models.SalidaVehiculoDTO;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.util.VehiculoUtil;

@Service
public class VigilanteServiceImpl implements VigilanteService {

	@Autowired
	private VehiculoService vehiculoService;
	
	@Autowired
	private CobroService cobroService;
	
	@Autowired
	private VehiculoUtil vehiculoUtil;
	
	@Override
	public void ingresaVehiculo(VehiculoDTO vehiculo) throws ExceptionVehiculoParqueado, ExecptionNoHayEspacioTipoVehiculo, ExecptionCampoInvalido, ExecptionNoPuedeIngresarProresticcionPlacaDia {
		
		
		int numVehiculo = vehiculoService.contarVehiculoXTipo(vehiculo.getTipo());
		boolean hayEspacioVehiculo = numVehiculo <= vehiculoUtil.tipoVehiculo(vehiculo.getTipo()).getTope();
		boolean puedeEntrarPorDigitoYDia = vehiculoUtil.puedeEntrarPorDigitoYDia(vehiculo.getPlaca());
		validarVehiculoAdentro(vehiculo.getPlaca());
		if (hayEspacioVehiculo && puedeEntrarPorDigitoYDia) {
			vehiculo.setFechaIngreso(new Date());
			vehiculoService.insertarVehivculo(vehiculo);
		}else if(!hayEspacioVehiculo){
			throw new ExecptionNoHayEspacioTipoVehiculo(MensajesConstantes.MENSAJE_NO_HAY_ESPACIO);
		}else {
			throw new ExecptionNoPuedeIngresarProresticcionPlacaDia(MensajesConstantes.MENSAJE_VEHICULO_NO_INGRESA);
		}
		
	}
	
	@Override
	public SalidaVehiculoDTO salirVehiculo(VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada, ExecptionVehiculoNoPaqueado, ExceptionSalidaNoRegistrada {

		SalidaVehiculoDTO salidaVehiculoDTO;
		if(vehiculoService.validarVehiculoEstaAdentro(vehiculo.getPlaca())) {
			vehiculo = vehiculoService.obtenerVehiculoXPlaca(vehiculo.getPlaca());
			vehiculo.setFechaSalida(new Date());
			salidaVehiculoDTO = new SalidaVehiculoDTO(vehiculo);
			salidaVehiculoDTO.setMontoCancelar(cobroService.calcularCobroVehiculo(vehiculo));
			vehiculoService.actualizarSalidaVehiculo(vehiculo);
		}else {
            throw new ExecptionVehiculoNoPaqueado(MensajesConstantes.MENSAJE_VEHICULO_NO_PARQUEADO); 
		}

		return salidaVehiculoDTO;
	}
	
	private void validarVehiculoAdentro(String placa) throws ExceptionVehiculoParqueado {
		boolean vehiculoAdentro = vehiculoService.validarVehiculoEstaAdentro(placa);
		if (vehiculoAdentro) {
			throw new ExceptionVehiculoParqueado(MensajesConstantes.MENSAJE_VEHICULO_YA_ESTA_EN_PARQUEO);
		}
	}

}
