package co.com.parking.parkingpractice.vigilante;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.parking.parkingpractice.business.services.impl.CobroServiceImpl;
import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.models.VehiculoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class UnitTestCobroServiceImpl {
	
	CobroServiceImpl  cobroService = new CobroServiceImpl();
	
	private static final int DIAS_MILISEGUNDOS = 86400000;
	private static final int HORAS_MILISEGUNDOS = 3600000;
	
	@Test
	public void cantidadDias() throws ExcepcionGenerica, ParseException {
		//Preparar los datos
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicial = dateFormat.parse("2018-02-14");
		Date fechaFinal = dateFormat.parse("2018-03-22");
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(36 == cobroService.cantidadDias(fechaInicial, fechaFinal)/DIAS_MILISEGUNDOS);
	}
	
	@Test
	public void calcularParteEnteraParteDecimalDias() throws ExcepcionGenerica, ParseException {
		//Preparar los datos
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date fechaInicial = dateFormat.parse("2018-08-20 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-23 11:00");
		
		double tiempoMilisegundos = cobroService.cantidadDias(fechaInicial, fechaFinal);
		double[] resultados = {3.0, 0.0};
		//Assert cuando Se obtiene el objeto tipo moto
		assertArrayEquals(resultados, cobroService.calcularParteEnteraParteDecimal(tiempoMilisegundos, DIAS_MILISEGUNDOS), 0.0);
	}
	
	@Test
	public void calcularParteEnteraParteDecimalHoras() throws ExcepcionGenerica, ParseException {
		//Preparar los datos
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date fechaInicial = dateFormat.parse("2018-08-23 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-23 12:00");
		
		double tiempoMilisegundos = cobroService.cantidadDias(fechaInicial, fechaFinal);
		double[] resultados = {1.0, 0.0};
		//Assert cuando Se obtiene el objeto tipo moto
		assertArrayEquals(resultados, cobroService.calcularParteEnteraParteDecimal(tiempoMilisegundos, HORAS_MILISEGUNDOS), 0.0);
	}
	
	//@Test
	public void calcularCobroVehiculo() throws ParseException, ExceptionTarifaNoEncontrada {
		//Preparar los datos
		when(cobroService.calcularCobro(3, 500)).thenReturn(1500);
		VehiculoDTO vehiculo = new VehiculoDTO("AGJ93D", "M");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date fechaInicial = dateFormat.parse("2018-08-23 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-23 14:00");
		vehiculo.setFechaIngreso(fechaInicial);
		vehiculo.setFechaSalida(fechaFinal);
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(1500 == cobroService.calcularCobroVehiculo(vehiculo));
	}
	
	
	
	

}
