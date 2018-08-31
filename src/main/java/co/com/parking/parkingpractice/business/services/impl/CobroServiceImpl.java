package co.com.parking.parkingpractice.business.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.parkingpractice.business.services.CobroService;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.business.services.TarifasService;
import co.com.parking.parkingpractice.constantes.TarifasConstantes;
import co.com.parking.parkingpractice.constantes.TipoVehiculoConstantes;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;

@Service
public class CobroServiceImpl implements CobroService {
	
	@Autowired
	private TarifasService tarifasService;
	
	private static final int DIAS_HORAS = 24;
	private static final int HORAS_TOPE_COBRO_DIA = 9;
	private static final int HORAS_MILISEGUNDOS = 3600000;
	private static final int SOBRE_COSTO_MOTO_500CC = 2000;
	
	public int calcularCobroVehiculo(VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada {
		int cobro = 0;
		
		double horasConMinutos = diferenciaTiempoHoras(vehiculo.getFechaIngreso(), vehiculo.getFechaSalida());
		if(horasConMinutos > DIAS_HORAS) {
			int numeroDias = calcularDias(horasConMinutos);
			cobro += calcularCobroPorDia(vehiculo, numeroDias);
			
			double horasRestantes = horasConMinutos - (numeroDias * DIAS_HORAS);
			
			cobro +=calcularHorasParaCobrar(horasRestantes, vehiculo);
			
		} else {
			cobro +=calcularHorasParaCobrar(horasConMinutos, vehiculo);
		}

		// Valor adicional por moto mayor a 500cc
		cobro += sobreCostoMotoAltoCC(vehiculo);
		return cobro;
	}
	
	@Override
	public int calcularHorasParaCobrar(double horas, VehiculoDTO vehiculo) throws ExceptionTarifaNoEncontrada {
		int cobro = 0;
		
		if( horas >= HORAS_TOPE_COBRO_DIA) {
			cobro += calcularCobroPorDia(vehiculo, 1);
		} else {
			int horasACobrar = (int) (horas > (int)horas ? horas + 1 : horas);
			cobro += calcularCobroPorHora(vehiculo, horasACobrar);
		}
		return cobro;
	}
	
	@Override
	public double diferenciaTiempoHoras(Date fechaInicio, Date fechaFin) {
		return (double)(fechaFin.getTime() - fechaInicio.getTime()) / HORAS_MILISEGUNDOS;
	}
	
	
	public int calcularDias(double horas) {
		return (int)(horas / DIAS_HORAS);
	}
	
	public int calcularCobroPorDia(VehiculoDTO vehiculo, int diasCompletos) throws ExceptionTarifaNoEncontrada {
		Integer idTarifa;
		if(TipoVehiculoConstantes.MOTO.equals(vehiculo.getTipo())) {
			idTarifa = TarifasConstantes.DIA_MOTO;
		}else {
			idTarifa = TarifasConstantes.DIA_CARO;
		}
		return this.calcularCobro(idTarifa,diasCompletos);
	}
	
	public int calcularCobroPorHora(VehiculoDTO vehiculo, int horasCompletos) throws ExceptionTarifaNoEncontrada {
		Integer idTarifa;
		if(TipoVehiculoConstantes.MOTO.equals(vehiculo.getTipo())) {
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
		if(TipoVehiculoConstantes.MOTO.equals(vehiculo.getTipo()) && vehiculo.getCilindraje() > 500) {
			sobreCosto = SOBRE_COSTO_MOTO_500CC;
		}
		return sobreCosto;
	}
}
