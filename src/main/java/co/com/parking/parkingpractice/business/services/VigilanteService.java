package co.com.parking.parkingpractice.business.services;

import co.com.parking.parkingpractice.ecxceptions.ExceptionSalidaNoRegistrada;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.ecxceptions.ExceptionVehiculoParqueado;
import co.com.parking.parkingpractice.ecxceptions.ExecptionCampoInvalido;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoHayEspacioTipoVehiculo;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoPuedeIngresarProresticcionPlacaDia;
import co.com.parking.parkingpractice.ecxceptions.ExecptionVehiculoNoPaqueado;
import co.com.parking.parkingpractice.models.SalidaVehiculoDTO;
import co.com.parking.parkingpractice.models.VehiculoDTO;

public interface VigilanteService {
	
	public void ingresaVehiculo(VehiculoDTO vehiculo) throws ExceptionVehiculoParqueado, ExecptionNoHayEspacioTipoVehiculo, ExecptionCampoInvalido, ExecptionNoPuedeIngresarProresticcionPlacaDia;

	SalidaVehiculoDTO salirVehiculo(VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada, ExecptionVehiculoNoPaqueado, ExceptionSalidaNoRegistrada;

}
