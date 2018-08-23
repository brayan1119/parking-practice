package co.com.parking.parkingpractice.business.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.parkingpractice.business.services.CobroService;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.util.TipoVehiculo;
import co.com.parking.parkingpractice.business.services.TarifasService;
import co.com.parking.parkingpractice.constantes.TarifasConstantes;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;

@Service
public class CobroServiceImpl implements CobroService {
	
	@Autowired
	private TarifasService tarifasService;
	
	private static final int DIAS_MILISEGUNDOS = 86400000;
	private static final int HORAS_MILISEGUNDOS = 3600000;
	private static final int SOBRE_COSTO_MOTO_500CC = 2000;
	
	public int calcularCobroVehiculo(VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada {
		double dias = cantidadDias(vehiculo.getFechaIngreso(), vehiculo.getFechaSalida());
		double[] vectorDesagregadoDias = calcularParteEnteraParteDecimal(dias, DIAS_MILISEGUNDOS);
		int diasCompletos = (int)vectorDesagregadoDias[0];
		double menosDelDia = vectorDesagregadoDias[1];
		int cobro = 0;
		if(diasCompletos > 0) {
			cobro += calcularCobroPorDia(vehiculo, diasCompletos);
		}
		double[] vectorDesagregadoHoras = calcularParteEnteraParteDecimal(menosDelDia, HORAS_MILISEGUNDOS);
		int horasCompletas = (int)vectorDesagregadoHoras[0];
		double menosDeHora = vectorDesagregadoHoras[1];
		if(horasCompletas >= 9 && menosDeHora > 0) {
			cobro += calcularCobroPorDia(vehiculo, 1);
		} 
		if(menosDeHora > 0) {
			horasCompletas += 1;
		}
		if(horasCompletas < 9) {
			cobro += calcularCobroPorDia(vehiculo, horasCompletas);
		}
		
		// Valor adicional por moto mayor a 500cc
		cobro += sobreCostoMotoAltoCC(vehiculo);
		return cobro;
	}
	
	public double cantidadDias(Date fechaInicio, Date fechaFin) {
		return (fechaFin.getTime() - fechaInicio.getTime());
	}
	
	// Posicion 0 parte entera posicion 1 parte decimal
	public double[] calcularParteEnteraParteDecimal(double numeroCompleto, int tiempoADividir) {
		numeroCompleto = numeroCompleto / tiempoADividir;
		double[] resultado = new double[2];
		resultado[0] = numeroCompleto;
		resultado[1] = (numeroCompleto - resultado[0])*tiempoADividir;
		return resultado;
	}
	
	public int calcularCobroPorDia(VehiculoDTO vehiculo, int diasCompletos) throws ExceptionTarifaNoEncontrada {
		Integer idTarifa;
		if(TipoVehiculo.MOTO.getTipo().equals(vehiculo.getTipo())) {
			idTarifa = TarifasConstantes.DIA_MOTO;
		}else {
			idTarifa = TarifasConstantes.DIA_CARO;
		}
		return this.calcularCobro(idTarifa,diasCompletos);
	}
	
	public int calcularCobroPorHora(VehiculoDTO vehiculo, int horasCompletos) throws ExceptionTarifaNoEncontrada {
		Integer idTarifa;
		if(TipoVehiculo.MOTO.getTipo().equals(vehiculo.getTipo())) {
			idTarifa = TarifasConstantes.HORA_MOTO;
		}else {
			idTarifa = TarifasConstantes.HORA_CARO;
		}
		
		return this.calcularCobro(idTarifa,horasCompletos);
	}
	
	public int calcularCobro(Integer idTarifa, int multiplicadorTiempo) throws ExceptionTarifaNoEncontrada {
		int valorHoraVehiculo = tarifasService.consultaTarifaDeVehiculo(idTarifa);
		return valorHoraVehiculo * multiplicadorTiempo;
	}

	public int sobreCostoMotoAltoCC(VehiculoDTO vehiculo) {
		int sobreCosto = 0;
		if(TipoVehiculo.MOTO.getTipo().equals(vehiculo.getTipo()) && vehiculo.getCilindraje() > 500) {
			sobreCosto = SOBRE_COSTO_MOTO_500CC; 
		}
		return sobreCosto;
	}
}
