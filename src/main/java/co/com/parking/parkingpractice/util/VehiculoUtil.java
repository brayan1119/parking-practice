package co.com.parking.parkingpractice.util;

import org.springframework.util.StringUtils;

import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;

public final class VehiculoUtil {
	
	private static final String INICIAL_PLACA = "A"; 
	
	private VehiculoUtil() {
		super();
	}
	
	public static TipoVehiculo tipoVehiculo(String tipo) throws ExcepcionGenerica{
		
		if(StringUtils.isEmpty(tipo)) {
			throw new ExcepcionGenerica(MensajesUtil.MENSAJE_TIPO_VEHICULO_VACIO);
		}
		
		TipoVehiculo vehiculo = null;
		
		if(TipoVehiculo.MOTO.getTipo().equals(tipo)) {
			vehiculo = TipoVehiculo.MOTO;
		} else if(TipoVehiculo.CARRO.getTipo().equals(tipo)) {
			vehiculo = TipoVehiculo.CARRO;
		} else {
			throw new ExcepcionGenerica(MensajesUtil.MENSAJE_TIPO_VEHICULO_INVALIDO);
		}
		return vehiculo;
	}
	
	public static boolean puedeEntrarPorDigitoYDia(String placa) throws ExcepcionGenerica {
		
		if(StringUtils.isEmpty(placa)) {
			throw new ExcepcionGenerica(MensajesUtil.MENSAJE_PLACA_VACIA);
		}
		
		return !(placa.startsWith(INICIAL_PLACA) && TiempoUtil.esLunesDomingo());
	}

}
