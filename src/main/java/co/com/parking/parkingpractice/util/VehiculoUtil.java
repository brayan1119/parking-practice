package co.com.parking.parkingpractice.util;

import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;

public class VehiculoUtil {
	
	private static final String INICIAL_PLACA = "A"; 
	
	private VehiculoUtil() {
		super();
	}
	
	public static TipoVehiculo tipoVehiculo(String tipo) throws ExcepcionGenerica{
		
		if(tipo == null) {
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
		
		if(placa == null) {
			throw new ExcepcionGenerica(MensajesUtil.MENSAJE_PLACA_VACIA);
		}
		
		return !(placa.startsWith(INICIAL_PLACA) && TiempoUtil.esLunesDomingo());
	}

}
