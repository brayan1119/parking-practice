package co.com.parking.parkingpractice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import co.com.parking.parkingpractice.constantes.MensajesConstantes;
import co.com.parking.parkingpractice.ecxceptions.ExecptionCampoInvalido;

@Component
public class VehiculoUtil {
	
	private static final String INICIAL_PLACA = "A";
	private static final String NOMBRE_CAMPO_TIPO = "Tipo Vehiculo";
	private static final String NOMBRE_CAMPO_PLACA = "Placa Vehiculo";
	
	@Autowired
	private TiempoUtil tiempoUtil;
	
	public TipoVehiculo tipoVehiculo(String tipo) throws ExecptionCampoInvalido{
		
		if(StringUtils.isEmpty(tipo)) {
			throw new ExecptionCampoInvalido(MensajesConstantes.MENSAJE_TIPO_VEHICULO_VACIO, NOMBRE_CAMPO_TIPO);
		}
		
		TipoVehiculo vehiculo = null;
		
		if(TipoVehiculo.MOTO.getTipo().equals(tipo)) {
			vehiculo = TipoVehiculo.MOTO;
		} else if(TipoVehiculo.CARRO.getTipo().equals(tipo)) {
			vehiculo = TipoVehiculo.CARRO;
		} else {
			throw new ExecptionCampoInvalido(MensajesConstantes.MENSAJE_TIPO_VEHICULO_INVALIDO, NOMBRE_CAMPO_TIPO);
		}
		return vehiculo;
	}
	
	public boolean puedeEntrarPorDigitoYDia(String placa) throws ExecptionCampoInvalido {

		if(StringUtils.isEmpty(placa)) {
			throw new ExecptionCampoInvalido(MensajesConstantes.MENSAJE_PLACA_VACIA, NOMBRE_CAMPO_PLACA);
		}
		
		return (!placa.startsWith(INICIAL_PLACA)) || tiempoUtil.esLunesDomingo();
	}

}
