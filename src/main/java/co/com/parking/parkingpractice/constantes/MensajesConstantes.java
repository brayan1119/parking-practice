package co.com.parking.parkingpractice.constantes;

public final class MensajesConstantes {

	private MensajesConstantes() {
		super();
	}
	
	public static final String MENSAJE_PLACA_VACIA = "La placa del vehiculo no puede estar vacia"; 
	public static final String MENSAJE_TIPO_VEHICULO_VACIO = "El tipo del vehiculo no puede estar vacio"; 
	public static final String MENSAJE_TIPO_VEHICULO_INVALIDO = "El tipo del vehiculo no es correcto";
	public static final String MENSAJE_NO_HAY_ESPACIO = "No hay espacio para el veiculo que intenta ingresar";
	public static final String MENSAJE_VEHICULO_NO_INGRESA = "El vehiculo no puede ingresar por restricción de dia y placa";
	public static final String MENSAJE_VEHICULO_YA_ESTA_EN_PARQUEO = "El vehiculo no puede ingresar por que ya esta adentro";
	public static final String MENSAJE_TARIFA_NO_ENCONTRADA = "La tarifa no fue encontrada";
	public static final String MENSAJE_SALIDA_NO_REGISTRADA = "La salida del vehiculo no fue registrada";
	public static final String MENSAJE_VEHICULO_NO_PARQUEADO = "El vehiculo no ha ingresado al parqueadero";
}
